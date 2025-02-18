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
        List<XdHotel> xdHotels = xdHotelMapper.selectByHotelBusinessIdAndTmp(0, 1);
        for (XdHotel xdHotel : xdHotels) {
            log.info("----------------------循环开始新酒店更新---------------------------");
            log.info("第{}行，酒店名称：{}elongid：{}", count, xdHotel.getName(), xdHotel.getEid());
            XdZElongHotels xdZElongHotels = xdZElongHotelsMapper.selectIdAndBusinessZoneById(String.valueOf(xdHotel.getEid()));
            if (xdZElongHotels != null) {
                log.info("第{}行，酒店名称：{}elongid：{},查询目标表不为空，进行businessZone判断", count, xdHotel.getName(), xdHotel.getEid());
                if (xdZElongHotels.getBusinessZone() != null) {
                    log.info("第{}行，酒店名称：{}elongid：{},businessZone判断不为空值为：{}", count, xdHotel.getName(), xdHotel.getEid(), xdZElongHotels.getBusinessZone());
                    xdHotelMapper.updateHotelBusinessIdById(Integer.valueOf(xdZElongHotels.getBusinessZone()), xdHotel.getId());
                    log.info("第{}行，酒店名称：{}elongid：{},businessZone判断不为空值为：{},更新完毕", count, xdHotel.getName(), xdHotel.getEid(), xdZElongHotels.getBusinessZone());
                }
            } else {
                xdZElongHotels = xdZElongHotelsMapper.selectIdAndBusinessZoneById("00" + xdHotel.getEid());
                if (xdZElongHotels != null) {
                    log.info("第{}行，酒店名称：{}elongid：{},查询加00目标表不为空，进行businessZone判断", count, xdHotel.getName(), xdHotel.getEid());
                    if (xdZElongHotels.getBusinessZone() != null) {
                        log.info("第{}行，酒店名称：{}elongid：{},查询加00的businessZone判断不为空值为：{}", count, xdHotel.getName(), xdHotel.getEid(), xdZElongHotels.getBusinessZone());
                        xdHotelMapper.updateHotelBusinessIdById(Integer.valueOf(xdZElongHotels.getBusinessZone()), xdHotel.getId());
                        log.info("第{}行，酒店名称：{}elongid：{},查询加00的businessZone判断不为空值为：{},更新完毕", count, xdHotel.getName(), xdHotel.getEid(), xdZElongHotels.getBusinessZone());
                    }
                } else {
                    xdZElongHotels = xdZElongHotelsMapper.selectIdAndBusinessZoneById("0" + xdHotel.getEid());
                    if (xdZElongHotels != null) {
                        log.info("第{}行，酒店名称：{}elongid：{},查询加0目标表不为空，进行businessZone判断", count, xdHotel.getName(), xdHotel.getEid());
                        if (xdZElongHotels.getBusinessZone() != null) {
                            log.info("第{}行，酒店名称：{}elongid：{},加0的businessZone判断不为空值为：{}", count, xdHotel.getName(), xdHotel.getEid(), xdZElongHotels.getBusinessZone());
                            xdHotelMapper.updateHotelBusinessIdById(Integer.valueOf(xdZElongHotels.getBusinessZone()), xdHotel.getId());
                            log.info("第{}行，酒店名称：{}elongid：{},加0的businessZone判断不为空值为：{},更新完毕", count, xdHotel.getName(), xdHotel.getEid(), xdZElongHotels.getBusinessZone());
                        }
                    }
                }
            }
            count++;
            log.info("第{}行，酒店名称：{}elongid：{}，循环结束", count, xdHotel.getName(), xdHotel.getEid());
            log.info("----------------------进入下一条---------------------------");
        }
        log.info("更新完成,总数：{}", count);
    }

    @Test
    public void executionMethod() {
        updateBusiness();
    }


}
