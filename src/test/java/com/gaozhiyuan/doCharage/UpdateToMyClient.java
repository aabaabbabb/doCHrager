package com.gaozhiyuan.doCharage;

import com.gaozhiyuan.doCharage.mapper.primary.*;
import com.gaozhiyuan.doCharage.model.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class UpdateToMyClient {

    @Autowired
    ShuipfHotelquyuMapper shuipfHotelquyuMapper;

    @Autowired
    XdMyClientMapper xdMyClientMapper;

    @Autowired
    XdHotelMapper xdHotelMapper;

    @Autowired
    XdAdminMapper xdAdminMapper;
    @Autowired
    XdTeamMapper xdTeamMapper;

    @Test
    public void toUpdate() {
        List<ShuipfHotelquyu>  shuipfHotelquyuList = outputData();
        log.info("更新条数：{}", shuipfHotelquyuList.size());
        log.info("开始更新");
        selectData(shuipfHotelquyuList);
        log.info("更新结束");
    }

    private List<ShuipfHotelquyu> outputData() {
        List<ShuipfHotelquyu> shuipfHotelquyuList = shuipfHotelquyuMapper.selectByIsUpdateAndIsImportAndEidIsNotNull(1,0);
        return shuipfHotelquyuList;
    }

    public boolean selectData(List<ShuipfHotelquyu> shuipfHotelquyuList){
        int count = 1;
        for (ShuipfHotelquyu shuipfHotelquyu : shuipfHotelquyuList){
            List<XdMyClient> XdMyClientList = new ArrayList<>();
            Integer uuid = shuipfHotelquyu.getId();
            Integer userid = shuipfHotelquyu.getCuruserid();
            String hotelname = shuipfHotelquyu.getHotelname();
            Integer createtime  = shuipfHotelquyu.getCreatetime();
            String eid = shuipfHotelquyu.getEid();
            Integer elongid = Integer.valueOf(eid);
            Integer cid = shuipfHotelquyu.getUserpid();
            if(cid == 0){
                cid =453;
            }
            if(userid == 0||userid==1){
                shuipfHotelquyuMapper.updateIsImportById(1,uuid);
                if (shuipfHotelquyuMapper.updateIsImportById(1,uuid) >0){
                    log.info("第{}条---eid：{}---eid为：{}，userid为空更新状态成功，进入下一条",count,eid,eid);
                }
                count++;
                continue;
            }
            XdAdmin user = xdAdminMapper.selectById(userid);
            if (user == null) {
                shuipfHotelquyuMapper.updateIsImportById(1,uuid);
                if (shuipfHotelquyuMapper.updateIsImportById(1,uuid) >0){
                    log.info("第{}条---eid：{}---eid为：{}，user为空更新状态成功，进入下一条",count,eid,eid);
                }
                count++;
                continue;
            }
            XdTeam xdTeam = xdTeamMapper.selectById(user.getTid());
            if (xdTeam == null) {
                shuipfHotelquyuMapper.updateIsImportById(1,uuid);
                if (shuipfHotelquyuMapper.updateIsImportById(1,uuid) >0){
                    log.info("第{}条---eid：{}---eid为：{}，Team更新状态成功，进入下一条",count,eid,eid);
                }
                count++;
                continue;
            }
            XdHotel xdHotel = xdHotelMapper.selectByEid(elongid);
            if(xdHotel == null){
                xdHotel = new XdHotel();
                xdHotel.setId(2025021400);
            }
            XdMyClient xdMyClients = xdMyClientMapper.selectByHidAndPid(xdHotel.getId(), xdTeam.getProjId());
            if (xdMyClients != null) {
                log.info("酒店名称：{}---eid：{}我联系的客户---有值，进行下一条",hotelname,eid);
                if (shuipfHotelquyuMapper.updateIsImportById(1,uuid) >0){
                    log.info("第{}条------eid为：{}，更新状态成功，进入下一条",count,eid);
                }
                count++;
                continue;
            }
            log.info("第{}条---酒店名称：{}---eid：{}---开始运行",count,hotelname,eid);
            xdHotel.setContactName(shuipfHotelquyu.getJingliname() == null ? null : shuipfHotelquyu.getJingliname());
            xdHotel.setContactPhone(shuipfHotelquyu.getJinglitel() == null ? null : shuipfHotelquyu.getJinglitel());
            log.info("酒店名称：{}---eid：{}酒店经理和电话信息开始更新",hotelname,eid);
            xdHotelMapper.updateContactNameAndContactPhoneById(xdHotel.getContactName(), xdHotel.getContactPhone(), xdHotel.getId());
            log.info("酒店名称：{}---eid：{}酒店经理和电话信息更新完毕",hotelname,eid);

            XdMyClient xdMyClient = new XdMyClient();
            xdMyClient.setCid(cid);
            xdMyClient.setPid(xdTeam.getProjId());
            xdMyClient.setTid(xdTeam.getId());
            xdMyClient.setTeamNames(xdTeam.getName());
            xdMyClient.setHid(xdHotel.getId());
            xdMyClient.setAid(userid);
            xdMyClient.setType(1);
            xdMyClient.setImportTime(createtime);
            xdMyClient.setOutPrivSeaTime(0);
            xdMyClient.setPrivSeaTime(0);
            xdMyClient.setOutPrivSeaTime(0);
            xdMyClient.setDuration(0);
            xdMyClient.setLastFid(0);
            xdMyClient.setDealTime(0);
            xdMyClient.setCreateTime(createtime);
            xdMyClient.setAlterTime(shuipfHotelquyu.getUpdatetime());
            xdMyClient.setOutTime(0);
            log.info("表中无值可以插入--酒店名称：{}---eid：{}我联系的客户---开始插入", hotelname, eid);
            XdMyClientList.add(xdMyClient);
            log.info("开始插入");
            xdMyClientMapper.insertAll(XdMyClientList);
            log.info("插入完毕");
            if (shuipfHotelquyuMapper.updateIsImportById(1, uuid) > 0) {
                log.info("第{}条---酒店名称：{}---eid：{}---运行结束，进行下一条", count, hotelname, eid);
            }
            count++;
        }
        log.info("插入完毕,条数：{}",count);
        return true;
    }
}
