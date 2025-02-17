package com.gaozhiyuan.doCharage;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gaozhiyuan.doCharage.mapper.primary.XdAdminMapper;
import com.gaozhiyuan.doCharage.mapper.primary.XdHotelMapper;
import com.gaozhiyuan.doCharage.mapper.primary.XdMyClientMapper;
import com.gaozhiyuan.doCharage.mapper.primary.XdTeamMapper;
import com.gaozhiyuan.doCharage.model.XdAdmin;
import com.gaozhiyuan.doCharage.model.XdHotel;
import com.gaozhiyuan.doCharage.model.XdMyClient;
import com.gaozhiyuan.doCharage.model.XdTeam;
import com.gaozhiyuan.doCharage.service.XdMyClientService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.lang.reflect.Array;
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

    public static  List<List<String>> readExcel(String filePath) throws IOException {

//        // 表头列的名称
//        List<String> headers = Arrays.asList(
//                "id", "userid", "hide", "userpid", "createtime", "hotelname", "eid", "jingliname",
//                "jinglitel", "bak", "curuserid", "updatetime", "status", "zid", "timerday", "timer",
//                "createtimelost", "price", "syncxdj", "ordercount", "ordercanclecount", "ordercountupdate",
//                "sellstatus", "viewcountuptime", "viewcountorder"
//        );
//uuid	userid	userpid	createtime	hotelname	eid	jingliname	jinglitel	curuserid	updatetime	zid	createtimelost	syncxdj	ordercount

        List<List<String>> resultList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // 读取每一行数据并存入 List
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("\uFEFF")) {
                    line = line.substring(1);  // 删除 BOM 字符
                }
                List<String> list = Arrays.asList(line.split(","));
                resultList.add(list);
            }
        }
        return resultList;
    }

    @Test
    public void data() throws IOException {
        List<List<String>>excelData = readExcel("C:\\Users\\Administrator\\Desktop\\Microsoft Excel999.csv");
        System.out.println(excelData.size());
        insertData(excelData);
    }

    @Autowired
    XdMyClientService xdMyClientService;
   private boolean insertData( List<List<String>> excelData){


       int count = 1;
       //0      1       2          3           4         5     6          7           8          9       10         11          12      13
       //uuid	userid	userpid	createtime	hotelname	eid	jingliname	jinglitel	curuserid	updatetime	zid	createtimelost	syncxdj	ordercount
        for (List<String> list : excelData){
            List<XdMyClient> XdMyClientList = new ArrayList<>();
            String id = list.get(0);
            String userid = list.get(8);
            if (userid.equals("0")|| userid.equals("1")|| userid.equals("")){
                continue;
            }
            String hotelname = list.get(4);
            String createtime  = list.get(3);
            String eid = list.get(5);
            if (eid.equals("1.11E+16")|| eid.equals("华辉酒店(惠州西湖东站店)")|| eid.equals("月格熙精品民宿(大理古城店)")){
                System.out.println("第"+count+"条---eid："+eid+"---eid为："+eid+"，进入断点");
                System.out.println("eid");
                continue;
            }
            XdHotel xdHotel = xdHotelMapper.selectByEid(Integer.parseInt(eid));
            if(xdHotel == null){
                xdHotel = new XdHotel();
                xdHotel.setId(2025021400);
            }

            if (xdMyClientMapper.selectByHid(xdHotel.getId()) != null) {
                System.out.println("酒店名称：" + hotelname + "---eid：" + eid + "我联系的客户---有值，进行下一条");
                continue;
            }
            System.out.println("第"+count+"条---酒店名称："+hotelname +"---eid："+eid+"---开始运行");
            xdHotel.setContactName(list.get(6) == null ? null : list.get(6));
            xdHotel.setContactPhone(list.get(7) == null ? null : list.get(7));

            System.out.println("酒店名称："+hotelname +"---eid："+eid+"酒店经理和电话信息开始更新");
            xdHotelMapper.updateContactNameAndContactPhoneById(xdHotel.getContactName(), xdHotel.getContactPhone(), xdHotel.getId());

            System.out.println("酒店名称："+hotelname +"---eid："+eid+"酒店经理和电话信息更新完毕");

            XdMyClient xdMyClient = new XdMyClient();
            Integer cid = Integer.parseInt(list.get(2));
            System.out.println("第"+count+"条---酒店名称："+hotelname +"---eid："+eid+"cid："+cid);
            XdAdmin user = xdAdminMapper.selectById(Integer.parseInt(userid));
            if (user != null) {
                XdTeam xdTeam = xdTeamMapper.selectById(user.getTid());
                if (Integer.parseInt(list.get(2))==0){
                    if (user.getCid()==null)
                        continue;
                    xdMyClient.setCid(user.getCid());
                }else{
                    xdMyClient.setCid(Integer.parseInt(list.get(2)));
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
                    continue;
                }
                xdMyClient.setCid(cid);
                xdMyClient.setPid(35);
                xdMyClient.setTid(62);
                xdMyClient.setTeamNames("备用（禁删）");
            }
//            xdMyClient.setId(Integer.parseInt(id));
            xdMyClient.setHid(xdHotel.getId());
            xdMyClient.setAid(Integer.parseInt(userid));
            xdMyClient.setType(1);
            xdMyClient.setImportTime(Integer.parseInt(createtime));
            xdMyClient.setOutPrivSeaTime(0);
            xdMyClient.setPrivSeaTime(0);
            xdMyClient.setOutPrivSeaTime(0);
            xdMyClient.setDuration(0);
            xdMyClient.setLastFid(0);
            xdMyClient.setDealTime(0);
            xdMyClient.setCreateTime(Integer.parseInt(createtime));
            xdMyClient.setAlterTime(Integer.parseInt(list.get(9)));
            xdMyClient.setOutTime(0);

            if (xdMyClientMapper.selectByHid(xdMyClient.getHid()) == null) {
                System.out.println("表中无值可以插入--酒店名称：" + hotelname + "---eid：" + eid + "我联系的客户---开始插入");
                XdMyClientList.add(xdMyClient);
                System.out.println("开始插入");
                xdMyClientMapper.insertAll(XdMyClientList);
                System.out.println("插入完毕");
            } else {
                System.out.println("酒店名称：" + hotelname + "---eid：" + eid + "我联系的客户---有值，进行下一条");
                continue;
            }
            System.out.println("第"+count+"条---酒店名称："+hotelname +"---eid："+eid+"---运行结束，进行下一条");
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
