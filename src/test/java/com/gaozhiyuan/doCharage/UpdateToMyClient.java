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

    @Autowired
    ShuipfHotelquyuGdHotelMapper shuipfHotelquyuGdHotelMapper;

    @Test
    public void toUpdate() {
        List<ShuipfHotelquyu>  shuipfHotelquyuList = outputData();
        //List<ShuipfHotelquyuGdHotel> shuipfHotelquyuGdHotels = gaoDeData();
        log.info("更新条数：{}", shuipfHotelquyuList.size());
        log.info("开始更新");
        selectData(shuipfHotelquyuList);
        log.info("更新结束");
    }

    private List<ShuipfHotelquyu> outputData() {
        List<ShuipfHotelquyu> shuipfHotelquyuList = shuipfHotelquyuMapper.selectByIsImport(0);
        return shuipfHotelquyuList;
    }

    private List<ShuipfHotelquyuGdHotel> gaoDeData(){
        List<ShuipfHotelquyuGdHotel> shuipfHotelquyuGdHotels = shuipfHotelquyuGdHotelMapper.selectByUpdatetimeBetweenAndIsUpdate(1735660800,1740369600, 0);
        return shuipfHotelquyuGdHotels;
    }

//    public boolean selectData(List<ShuipfHotelquyu> shuipfHotelquyuList){
public boolean selectData(List<ShuipfHotelquyu>  shuipfHotelquyuList){
        int count = 1;
        for (ShuipfHotelquyu shuipfHotelquyu : shuipfHotelquyuList){
            List<XdMyClient> XdMyClientList = new ArrayList<>();
            Integer uuid = shuipfHotelquyu.getId();
            Integer userid = shuipfHotelquyu.getCuruserid();
            String hotelname = shuipfHotelquyu.getHotelname();
            log.info("第{}条------hotelname是：{}，开始执行",count,hotelname);
            Integer createtime  = shuipfHotelquyu.getCreatetime();
            String eid = shuipfHotelquyu.getEid().equals("") ? "0" : shuipfHotelquyu.getEid();
            Integer elongid = Integer.valueOf(eid);
            Integer cid = shuipfHotelquyu.getUserpid();

            if(cid == 0){
                cid =453;
            }
            if(userid == 0||userid==1||userid==494||elongid==0){
                if (shuipfHotelquyuMapper.updateIsImportById(1,uuid) >0){
                    log.info("第{}条---eid：{}---eid为：{}，userid为空更新状态成功，进入下一条",count,eid,eid);
                }
                count++;
                continue;
            } else if (userid == 31) {
                userid =445118;
            }
            XdAdmin user = xdAdminMapper.selectById(userid);
            if (user == null) {
                if (shuipfHotelquyuMapper.updateIsImportById(1,uuid) >0){
                    log.info("第{}条---eid：{}---eid为：{}，user为空更新状态成功，进入下一条",count,eid,eid);
                }
                count++;
                continue;
            }
            XdTeam xdTeam = xdTeamMapper.selectById(user.getTid());
            if (xdTeam == null) {
                if (shuipfHotelquyuMapper.updateIsImportById(1,uuid) >0){
                    log.info("第{}条---eid：{}---eid为：{}，Team更新状态成功，进入下一条",count,eid,eid);
                }
                count++;
                continue;
            }
            XdHotel xdHotel = xdHotelMapper.selectByEid(eid);
            if(xdHotel == null){
                if(eid.equals("26547874")){
                    xdHotel = new XdHotel();
                    xdHotel.setId(26547874);
                    xdHotel.setName("望屿听海民宿");
                }else if(eid.equals("5141004")){
                    xdHotel = new XdHotel();
                    xdHotel.setId(5141004);
                    xdHotel.setName("厦门泛太平洋大酒店");
                }else{
                    log.info("酒店名称：{}---eid：{}我联系的客户---有值，进行下一条", hotelname, eid);
                    if (shuipfHotelquyuMapper.updateIsImportById(1, uuid) > 0) {
                        log.info("第{}条------eid为：{}，更新状态成功，进入下一条", count, eid);
                    }
                    count++;
                    continue;
                }
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
