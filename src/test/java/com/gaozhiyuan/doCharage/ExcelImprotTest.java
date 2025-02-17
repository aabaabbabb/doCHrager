package com.gaozhiyuan.doCharage;

import com.gaozhiyuan.doCharage.mapper.primary.*;
import com.gaozhiyuan.doCharage.model.*;
import com.gaozhiyuan.doCharage.service.XdMyClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;


@SpringBootTest
public class ExcelImprotTest {

    @Autowired
     XdMyClientMapper xdMyClientMapper;
    @Autowired
     XdHotelMapper xdHotelMapper;
    @Autowired
    XdAdminMapper xdAdminMapper;
    @Autowired
    XdTeamMapper xdTeamMapper;
    @Autowired
    XdZooTableMapper xdZooTableMapper;

    public List<XdZooTable> readExcel() throws IOException {

//        // 表头列的名称
//        List<String> headers = Arrays.asList(
//                "id", "userid", "hide", "userpid", "createtime", "hotelname", "eid", "jingliname",
//                "jinglitel", "bak", "curuserid", "updatetime", "status", "zid", "timerday", "timer",
//                "createtimelost", "price", "syncxdj", "ordercount", "ordercanclecount", "ordercountupdate",
//                "sellstatus", "viewcountuptime", "viewcountorder"
//        );
//uuid	userid	userpid	createtime	hotelname	eid	jingliname	jinglitel	curuserid	updatetime	zid	createtimelost	syncxdj	ordercount


        List<XdZooTable> xdZooTables = xdZooTableMapper.selectByDaoru(0);


//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            // 读取每一行数据并存入 List
//            while ((line = reader.readLine()) != null) {
//                if (line.startsWith("\uFEFF")) {
//                    line = line.substring(1);  // 删除 BOM 字符
//                }
//                List<String> list = Arrays.asList(line.split(","));
//                resultList.add(list);
//            }
//        }
        return xdZooTables;
    }

    @Test
    public void data() throws IOException {
        List<XdZooTable> excelData = readExcel();
        System.out.println(excelData.size());
        insertData(excelData);
    }

    @Autowired
    XdMyClientService xdMyClientService;
   private boolean insertData( List<XdZooTable> excelData){


       int count = 1;
       //0      1       2          3           4         5     6          7           8          9       10         11          12      13
       //uuid	userid	userpid	createtime	hotelname	eid	jingliname	jinglitel	curuserid	updatetime	zid	createtimelost	syncxdj	ordercount
        for (XdZooTable xdZooTable : excelData){
            List<XdMyClient> XdMyClientList = new ArrayList<>();
            Integer uuid = xdZooTable.getUuid();
            Integer userid = xdZooTable.getCuruserid();
            String hotelname = xdZooTable.getHotelname();
            Integer createtime  = xdZooTable.getCreatetime();
            Long eid = xdZooTable.getEid();
            if (userid.equals("0")|| userid.equals("1")|| userid.equals("")){
                xdZooTableMapper.updateDaoruByUuid(1,uuid);
                if (xdZooTableMapper.updateDaoruByUuid(1,uuid) >0){
                    System.out.println("第"+count+"条---eid："+eid+"---eid为："+eid+"，更新状态成功，进入吓一条");
                }
                    count++;
                    continue;
            }

            if (eid ==0||eid==101012){
                System.out.println("第"+count+"条---eid："+eid+"---eid为："+eid+"，进入断点");
                System.out.println("eid");
                if (xdZooTableMapper.updateDaoruByUuid(1,uuid) >0){
                    System.out.println("第"+count+"条---eid："+eid+"---eid为："+eid+"，更新状态成功，进入吓一条");
                }
                count++;
                continue;
            }
            int elongid = eid.intValue();
            XdHotel xdHotel = xdHotelMapper.selectByEid(elongid);
            if(xdHotel == null){
                xdHotel = new XdHotel();
                xdHotel.setId(2025021400);
            }

            if (xdMyClientMapper.selectByHid(xdHotel.getId()) != null) {
                System.out.println("酒店名称：" + hotelname + "---eid：" + eid + "我联系的客户---有值，进行下一条");
                if (xdZooTableMapper.updateDaoruByUuid(1,uuid) >0){
                    System.out.println("第"+count+"条---eid："+eid+"---eid为："+eid+"，更新状态成功，进入吓一条");
                }
                count++;
                continue;
            }
            System.out.println("第"+count+"条---酒店名称："+hotelname +"---eid："+eid+"---开始运行");
            xdHotel.setContactName(xdZooTable.getJingliname() == null ? null : xdZooTable.getJingliname());
            xdHotel.setContactPhone(xdZooTable.getJinglitel() == null ? null : xdZooTable.getJinglitel());

            System.out.println("酒店名称："+hotelname +"---eid："+eid+"酒店经理和电话信息开始更新");
            xdHotelMapper.updateContactNameAndContactPhoneById(xdHotel.getContactName(), xdHotel.getContactPhone(), xdHotel.getId());

            System.out.println("酒店名称："+hotelname +"---eid："+eid+"酒店经理和电话信息更新完毕");

            XdMyClient xdMyClient = new XdMyClient();
            Integer cid = xdZooTable.getUserpid();
            System.out.println("第"+count+"条---酒店名称："+hotelname +"---eid："+eid+"cid："+cid);
            XdAdmin user = xdAdminMapper.selectById(userid);
            if (user != null) {
                XdTeam xdTeam = xdTeamMapper.selectById(user.getTid());
                if (xdZooTable.getUserpid()==0){
                    if (user.getCid()==null) {
                        if (xdZooTableMapper.updateDaoruByUuid(1,uuid) >0){
                            System.out.println("第"+count+"条---eid："+eid+"---eid为："+eid+"，更新状态成功，进入吓一条");
                        }
                        count++;
                        continue;
                    }
                    xdMyClient.setCid(user.getCid());
                }else{
                    xdMyClient.setCid(cid);
                }
                if (xdTeam != null) {
                    xdMyClient.setPid(xdTeam.getProjId());
                    xdMyClient.setTid(xdTeam.getId());
                    xdMyClient.setTeamNames(xdTeam.getName());
                }else{
                    if (user.getId()==31) {
                        xdMyClient.setPid(35);
                        xdMyClient.setTid(67);
                        xdMyClient.setTeamNames("战狼队");
                    }else{
                        xdMyClient.setPid(35);
                        xdMyClient.setTid(62);
                        xdMyClient.setTeamNames("备用（禁删）");
                    }
                }
            }else{
                if (cid==0){
                    if (xdZooTableMapper.updateDaoruByUuid(1,uuid) >0){
                        System.out.println("第"+count+"条---eid："+eid+"---eid为："+eid+"，更新状态成功，进入吓一条");
                    }
                    count++;
                    continue;
                }
                xdMyClient.setCid(cid);
                xdMyClient.setPid(35);
                xdMyClient.setTid(62);
                xdMyClient.setTeamNames("备用（禁删）");
            }
//            xdMyClient.setId(Integer.parseInt(id));
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
            xdMyClient.setAlterTime(xdZooTable.getUpdatetime());
            xdMyClient.setOutTime(0);

            if (xdMyClientMapper.selectByHid(xdMyClient.getHid()) == null) {
                System.out.println("表中无值可以插入--酒店名称：" + hotelname + "---eid：" + eid + "我联系的客户---开始插入");
                XdMyClientList.add(xdMyClient);
                System.out.println("开始插入");
                xdMyClientMapper.insertAll(XdMyClientList);
                System.out.println("插入完毕");
            } else {
                System.out.println("酒店名称：" + hotelname + "---eid：" + eid + "我联系的客户---有值，进行下一条");
                if (xdZooTableMapper.updateDaoruByUuid(1,uuid) >0){
                    System.out.println("第"+count+"条---eid："+eid+"---eid为："+eid+"，更新状态成功，进入吓一条");
                }
                count++;
                continue;
            }
            if (xdZooTableMapper.updateDaoruByUuid(1,uuid) >0){
                System.out.println("第"+count+"条---酒店名称："+hotelname +"---eid："+eid+"---运行结束，进行下一条");
            }
            count++;
        }

       System.out.println("插入完毕,条数："+count);
       return true;
   }

    public static void main(String[] args) {
        String eid = "1.11E+16";
        // 使用 BigDecimal 处理科学计数法格式
        BigDecimal bigDecimal = new BigDecimal(eid);
        // 将 BigDecimal 转换为 long
        long number = bigDecimal.longValue();
        System.out.println(number);
    }

}
