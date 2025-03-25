package com.gaozhiyuan.doCharage;

import com.gaozhiyuan.doCharage.mapper.primary.XdHotelMapper;
import com.gaozhiyuan.doCharage.service.LcElongHotelsService;
import com.gaozhiyuan.doCharage.service.XdHotelService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.IOException;
import java.util.Map;

@SpringBootTest
public class SecondaryDataSourceIntegrationTest {
    @Autowired
    private LcElongHotelsService lcElongHotelsService;
    @Autowired
    private XdHotelService xdHotelService;
    @Autowired
    private XdHotelMapper xdHotelMapper;

    @Test
    void testDatabaseConnection2() {
        //httpqingqingqiu();
//        List<XdHotel> xdHotelList = xdHotelMapper.selectEidAndZidAndNameByZidAndTmp(0,1);
//        System.out.println(xdHotelList.size());
//        int count = 1;
//        OkHttpClient client = new OkHttpClient.Builder()
//            .connectTimeout(30, TimeUnit.SECONDS)  // 设置连接超时为30秒
//                .readTimeout(30, TimeUnit.SECONDS)     // 设置读取超时
//                .writeTimeout(30, TimeUnit.SECONDS)    // 设置写入超时
//                .build();
//        for (XdHotel xdHotel : xdHotelList){
//            System.out.println("开始执行：************第"+count+"个酒店**********");
//            Integer eid = xdHotel.getEid();
//            Map<String, String> dataMap = getResponse(client,eid);
//            // 检查 dataMap 是否为 null
//            if (dataMap == null) {
//                System.out.println("响应数据为空，跳过eid: " + eid);
//                continue;
//            }
//            System.out.println("住哪id:"+dataMap.get("id")+"---酒店名称："+dataMap.get("hotelname")+"---开始更新---");
//            Integer zid = Integer.valueOf(dataMap.get("id"));
//            xdHotelMapper.updateZidByEid(zid,eid);
//            System.out.println("住哪id:"+dataMap.get("id")+"---酒店名称："+dataMap.get("hotelname")+"---更新成功---");
//            System.out.println("执行：************第"+count+"个酒店**********成功");
//            count++;
//        }
//        System.out.println("完成");
    }


//    public static List<Map<String, String>> readExcel(String filePath) throws IOException {
//        List<Map<String, String>> data = new ArrayList<>();
//        try (FileInputStream fis = new FileInputStream(filePath)) {
//            Workbook workbook = new HSSFWorkbook(fis);  // .xls 格式，.xlsx 格式使用 XSSFWorkbook
//            Sheet sheet = workbook.getSheetAt(0);  // 读取第一个工作表
//
//            // 获取表头
//            Row headerRow = sheet.getRow(0);
//            int cellCount = headerRow.getPhysicalNumberOfCells();
//
//            // 遍历每一行（从第二行开始）
//            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//                Row row = sheet.getRow(i);
//                if (row == null) continue;
//
//                Map<String, String> rowData = new HashMap<>();
//                for (int j = 0; j < cellCount; j++) {
//                    Cell cell = row.getCell(j);
//                    if (cell != null) {
//                        rowData.put(headerRow.getCell(j).getStringCellValue(), cell.toString());
//                    }
//                }
//                data.add(rowData);
//            }
//        }
//        return data;
//    }


    public  Map<String, String> getResponse( OkHttpClient client,Integer eid){

        String elongid = eid.toString();
        Request request = new Request.Builder()
                .url("http://tp1.src.watu.cn/updata/v1217/get_hotelDetail_elong.php?eid="+elongid)
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                .header("Accept-Language", "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7,zh-TW;q=0.6")
                .header("Cache-Control", "max-age=0")
                .header("Proxy-Connection", "keep-alive")
                .header("Upgrade-Insecure-Requests", "1")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // 读取内容
            String responseBody = response.body().string();

            // 使用 Gson 将 JSON 字符串转换为 Map
            Gson gson = new Gson();
            Map<String, String> map = gson.fromJson(responseBody, new TypeToken<Map<String, String>>(){}.getType());
            // 打印 Map 内容
            System.out.println(map);
            return map;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


   public void httpqingqingqiu(){
       OkHttpClient client = new OkHttpClient();
    //40101022
       String hotelid = "92490483";
       Request request = new Request.Builder()
               .url("https://www.elong.com/tapi/hoteldetailroomlist?hotelid="+hotelid+"&indate=2025-02-13&outdate=2025-02-14&adultsNumber=2&childrenAges=&filterList=&rechargeTicket=1&searchEntranceId=h5_home&traceToken=&if=&of=&ch=&refid=")
               .header("accept", "application/json, text/plain, */*")
               .header("accept-language", "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7,zh-TW;q=0.6")
               .header("appfrom", "15")
               .header("cookie", "H5CookieId=8d5748bc-e941-4479-bfb3-5645f444a60c; firsttime=1738836546607; _ga=GA1.1.1711880908.1738803656; _ga_3448JMBL38=GS1.1.1738898796.4.0.1738898796.0.0.0; H5Channel=mnoreferseo%2CSEO; CookieGuid=9a430bec-62ac-4145-bc57-d3ec41156614; SessionGuid=ba70581b-7014-424a-9c15-151fcf862ffb; Esid=bbb64e6e-2640-4084-a444-f323eb33c5db; com.eLong.CommonService.OrderFromCookieInfo=\"Status=1&Orderfromtype=1&Isusefparam=0&Pkid=50&Parentid=50000&Coefficient=0.0&Makecomefrom=0&Cookiesdays=0&Savecookies=0&Priority=8000\"; fv=pcweb; SessionToken=76a2c402-8daf-43c6-8805-eb6d384bbf3a622; Lgid=I3POdDcuso9TjVvZ96BcKyMXqazGPiQvaOg414K2lT1FJ1WwJ5Rs5cEhx98yyR6c%2B6o68aazQ2LJPgnVUqv%2FwKziNxvgZnfm3bPocaXSFZXBi4x278dLHF6oNboO%2B1IjvelG4TSfnbuV%2FVwz3dKdRw%3D%3D; tcUser=%7B%22AccessToken%22%3A%22035AF37629521E116802A352FD3C6057%22%2C%22MemberId%22%3A%22a9975998ef6090ae9a2ade9a2bfbbd1b%22%7D; searchEntranceId=h5_home; indate=2025-02-13; outdate=2025-02-14; lasttime=1739459458957; JSESSIONID=13C34C7EB5D80A82DE658EF7899450B4")
               .header("deviceid", "8d5748bc-e941-4479-bfb3-5645f444a60c")
               .header("lang", "zh-cn")
               .header("priority", "u=1, i")
               .header("referer", "https://www.elong.com/hotel/hoteldetail?hotelId="+hotelid+"&traceToken=|*|cityId:101|*|qId:768424e4-3abd-443e-8ffb-64c875f1f43f|*|st:city|*|sId:101|*|scene_ids:127|*|pos:0|*|hId:"+hotelid+"|*|Tp:default|*|page_index:0|*|page_size:10|*|&inDate=2025-02-13&outDate=2025-02-14&sourcePage=&sourcePrice=")
               .header("sec-ch-ua", "\"Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24\"")
               .header("sec-ch-ua-mobile", "?0")
               .header("sec-ch-ua-platform", "\"Windows\"")
               .header("sec-fetch-dest", "empty")
               .header("sec-fetch-mode", "cors")
               .header("sec-fetch-site", "same-origin")
               .header("timezone", "8")
               .header("tmapi-client", "epc")
               .header("traceid", "29d0991c-d280-4049-99f6-658ac1c78661")
               .header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36")
               .header("user-dun", "x7NxxxxxIIcw4XxxItXLIptEGWlAgxCIx7CCx5QqhqCOWaKFa5IRwA6Q+IVco/7IaiI/X8cIxx5mibFQiqx98ImQVsx4OImrTDphC9BanQ6jlAgilNA6qAga1bA/WJO5Xh1/DJO5XhLQTOqJ3MeGxbOwTWcjtJSH9Dtmhad5eEHQXAlHeNHmfeS+Cch7bwj76Hucp8SCApc4qsmJi6c9ldkH43H6Ka3HEoB4gomPynA/YjPii6c1hJKji7GwbkggVsiDOIjkVec4ldkvV6cZ8I57PsAx8S92bge3fr87w+8ylsKStSciq68vtOcV+lt7Im8V154rIZpVfmWJ6neT3AQs/dxZiqmsovltYy15AyamZFs7AACbCw3HVHpbZPlc0RGP1LdUyaxbXFc5H91W8JzqGaaL1kfeevpbl5+6ayiWZS2eEIxP3rw9LWASTHrknK+a10qwnmtTejZ7ejx09srw98xHD8oI9/aupsZXe/x++BaZnmAk1BkvcjvX1BH4ak8HA5ERGpp89UqVCXqplwXW6kaOAkXARWtVsHl0RHS0Od43YjCXOwXx6JhXAmaLWmlh8B1UTy9V5zjCog7vfBr8JvFskHq6xct08r9dHhs+HUywJHS6odnRHFsoeIaA8qp7Js8spLhMfhN7owCESd3401znfucU2oJ4T1mHxxjYas7Ia55=")
               .build();

       try (Response response = client.newCall(request).execute()) {
           System.out.println(response.body().string());
           if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
           response.body().string();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

   }

}
