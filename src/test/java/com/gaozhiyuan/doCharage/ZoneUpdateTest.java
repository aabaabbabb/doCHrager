package com.gaozhiyuan.doCharage;

import com.gaozhiyuan.doCharage.mapper.primary.XdHotelMapper;
import com.gaozhiyuan.doCharage.mapper.primary.XdZElongHotelsMapper;
import com.gaozhiyuan.doCharage.model.XdHotel;
import com.gaozhiyuan.doCharage.model.XdZElongHotels;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class ZoneUpdateTest {

    @Autowired
    XdZElongHotelsMapper xdZElongHotelsMapper;
    @Autowired
    XdHotelMapper xdHotelMapper;

    public void updateBusiness() {

        int count = 1;
        for (int i = 0; i < 10; i++) {
            // 假设我们要查询第 0 页的数据，每页 10 万条
            log.info("----------------------进入第{}页---------------------------", i);
            int offset = i;
            int limit = (i + 1) * 100000;
            List<XdHotel> xdHotels = xdHotelMapper.selectByTmpAndHotelStarId(0,0, offset, limit);
            if (xdHotels.size()==0) {
                log.info("----------------------第{}页数据为空---------------------------", i);
                continue;
            }
            for (XdHotel xdHotel : xdHotels) {
                log.info("----------------------循环开始新酒店更新---------------------------");
                log.info("总数{}，第{}行，酒店名称：{}elongid：{}",xdHotels.size(), count, xdHotel.getName(), xdHotel.getEid());
                XdZElongHotels xdZElongHotels = xdZElongHotelsMapper.selectIdAndCategoryAndBrandIdAndEstablishmentDateAndRenovationDateAndBusinessZoneAndHoteltypesById(String.valueOf(xdHotel.getEid()));
                if (xdZElongHotels != null) {
                    log.info("总数{}，第{}行，酒店名称：{}elongid：{},判断不为空值", xdHotels.size(),count, xdHotel.getName(), xdHotel.getEid());
                    String hotelTypes = (xdZElongHotels.getHoteltypes() == null) ? "0" : xdZElongHotels.getHoteltypes();
                    String BusinessZone = (xdZElongHotels.getBusinessZone() == null) ? "0" : xdZElongHotels.getBusinessZone();
                    Integer BrandId = (xdZElongHotels.getBrandId() == null) ? 0 : xdZElongHotels.getBrandId();
                    Integer Category = (xdZElongHotels.getCategory() == null) ? 0 : xdZElongHotels.getCategory();
                    String EstablishmentDate = (xdZElongHotels.getEstablishmentDate() == null) ? "" : xdZElongHotels.getEstablishmentDate();
                    String RenovationDate = (xdZElongHotels.getRenovationDate() == null) ? "" : xdZElongHotels.getRenovationDate();
                    String eid = (xdZElongHotels.getId() == null) ? "" : xdZElongHotels.getId();
                    String city_id = (xdZElongHotels.getCityId() == null) ? "" : xdZElongHotels.getCityId();
                    xdHotelMapper.updateHotelBusinessIdAndHotelCategoryIdAndHotelBrandIdAndHotelStarIdAndStartBusinessTimeAndFitmentTimeById(Integer.valueOf(BusinessZone), hotelTypes, BrandId,Category ,EstablishmentDate , RenovationDate,eid,city_id,1,xdHotel.getId());
                    log.info("总数{}，第{}行，酒店名称：{}elongid：{},更新完毕",xdHotels.size(), count, xdHotel.getName(), xdHotel.getEid());
                } else {
                    xdZElongHotels = xdZElongHotelsMapper.selectIdAndCategoryAndBrandIdAndEstablishmentDateAndRenovationDateAndBusinessZoneAndHoteltypesById("00" + xdHotel.getEid());
                    if (xdZElongHotels != null) {
                        log.info("总数{}，第{}行，酒店名称：{}elongid：{},查询加---00---判断不为空值",xdHotels.size(), count, xdHotel.getName(), xdHotel.getEid());
                        String hotelTypes = (xdZElongHotels.getHoteltypes() == null) ? "0" : xdZElongHotels.getHoteltypes();
                        String BusinessZone = (xdZElongHotels.getBusinessZone() == null) ? "0" : xdZElongHotels.getBusinessZone();
                        Integer BrandId = (xdZElongHotels.getBrandId() == null) ? 0 : xdZElongHotels.getBrandId();
                        Integer Category = (xdZElongHotels.getCategory() == null) ? 0 : xdZElongHotels.getCategory();
                        String EstablishmentDate = (xdZElongHotels.getEstablishmentDate() == null) ? "" : xdZElongHotels.getEstablishmentDate();
                        String RenovationDate = (xdZElongHotels.getRenovationDate() == null) ? "" : xdZElongHotels.getRenovationDate();
                        String eid = (xdZElongHotels.getId() == null) ? "" : xdZElongHotels.getId();
                        String city_id = (xdZElongHotels.getCityId() == null) ? "" : xdZElongHotels.getCityId();
                        xdHotelMapper.updateHotelBusinessIdAndHotelCategoryIdAndHotelBrandIdAndHotelStarIdAndStartBusinessTimeAndFitmentTimeById(Integer.valueOf(BusinessZone), hotelTypes, BrandId,Category ,EstablishmentDate , RenovationDate,eid,city_id,1,xdHotel.getId());
                        log.info("总数{}，第{}行，酒店名称：{}elongid：{},查询加---00---更新完毕",xdHotels.size(), count, xdHotel.getName(), xdHotel.getEid());
                    } else {
                        xdZElongHotels = xdZElongHotelsMapper.selectIdAndCategoryAndBrandIdAndEstablishmentDateAndRenovationDateAndBusinessZoneAndHoteltypesById("0" + xdHotel.getEid());
                        if (xdZElongHotels != null) {
                            log.info("总数{}，第{}行，酒店名称：{}elongid：{},查询加---0---判断不为空值",xdHotels.size(), count, xdHotel.getName(), xdHotel.getEid());
                            String hotelTypes = (xdZElongHotels.getHoteltypes() == null) ? "0" : xdZElongHotels.getHoteltypes();
                            String BusinessZone = (xdZElongHotels.getBusinessZone() == null) ? "0" : xdZElongHotels.getBusinessZone();
                            Integer BrandId = (xdZElongHotels.getBrandId() == null) ? 0 : xdZElongHotels.getBrandId();
                            Integer Category = (xdZElongHotels.getCategory() == null) ? 0 : xdZElongHotels.getCategory();
                            String EstablishmentDate = (xdZElongHotels.getEstablishmentDate() == null) ? "" : xdZElongHotels.getEstablishmentDate();
                            String RenovationDate = (xdZElongHotels.getRenovationDate() == null) ? "" : xdZElongHotels.getRenovationDate();
                            String eid = (xdZElongHotels.getId() == null) ? "" : xdZElongHotels.getId();
                            String city_id = (xdZElongHotels.getCityId() == null) ? "" : xdZElongHotels.getCityId();
                            xdHotelMapper.updateHotelBusinessIdAndHotelCategoryIdAndHotelBrandIdAndHotelStarIdAndStartBusinessTimeAndFitmentTimeById(Integer.valueOf(BusinessZone), hotelTypes, BrandId,Category ,EstablishmentDate , RenovationDate,eid,city_id,1,xdHotel.getId());
                            log.info("总数{}，第{}行，酒店名称：{}elongid：{},查询加---0---更新完毕",xdHotels.size(),  count, xdHotel.getName(), xdHotel.getEid());
                        }
                    }
                }
                count++;
                log.info("总数{}，第{}行，酒店名称：{}elongid：{}，循环结束",xdHotels.size(), count, xdHotel.getName(), xdHotel.getEid());
                log.info("----------------------进入下一条---------------------------");
            }

            log.info("----------------------进入下一页---------------------------");
        }
        log.info("更新完成,总数：{}", count);
    }

    @Test
    public void executionMethod() {
//        List<XdHotel> xdHotels = xdHotelMapper.selectByTmpAndHotelStarId(1,0);
//        System.out.println(xdHotels.size());
        updateBusiness();
    }


}
