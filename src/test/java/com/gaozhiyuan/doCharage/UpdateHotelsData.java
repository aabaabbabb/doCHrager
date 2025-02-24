package com.gaozhiyuan.doCharage;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gaozhiyuan.doCharage.mapper.primary.*;
import com.gaozhiyuan.doCharage.model.*;
import com.gaozhiyuan.doCharage.service.ShuipfHotelquyuGdHotelYejiService;
import com.gaozhiyuan.doCharage.service.impl.ShuipfHotelquyuGdHotelYejiServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ResultHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@SpringBootTest
@Slf4j
public class UpdateHotelsData {

    @Autowired
    private GdEbookingEmployeeHotelMapper gdEbookingEmployeeHotelMapper;
    @Autowired
    private XdHotelMapper xdHotelMapper;
    @Autowired
    private GdEbookingHotelsMapper gdEbookingHotelsMapper;
    @Autowired
    private XdHotelExpandMapper xdHotelExpandMapper;
    @Autowired
    private ShuipfHotelquyuGdHotelYejiMapper shuipfHotelquyuGdHotelYejiMapper;

    @Test
    public void executionTest() {
//        List<ShuipfHotelquyuGdHotelYeji> shuipfHotelquyuGdHotelYejis = shuipfHotelquyuGdHotelYejiMapper.selectUseridByEid("18082899");
//        Integer userid = shuipfHotelquyuGdHotelYejis.get(0).getUserid();
//        System.out.println(userid);

        List<GdEbookingEmployeeHotel> gdEbookingEmployeeHotels = queryData();
        // 更新数据
        doUpdate(gdEbookingEmployeeHotels);
        log.info("更新结束");
    }

    private List<GdEbookingEmployeeHotel> queryData() {
        log.info("开始查询数据");
        // 获取数据
        List<Integer> roleIdList = new ArrayList<>();
        roleIdList.add(3);
        roleIdList.add(4);

        List<GdEbookingEmployeeHotel> gdEbookingEmployeeHotels = gdEbookingEmployeeHotelMapper.selectElongHotelIdByRoleIdIn(roleIdList);

        log.info("结束查询数据条数：{}", gdEbookingEmployeeHotels.size());
        return gdEbookingEmployeeHotels;
    }

    private void doUpdate(List<GdEbookingEmployeeHotel> dataList) {
        int logCounter = 1; // 初始化计数器

        for (GdEbookingEmployeeHotel gdEbookingEmployeeHotel : dataList) {
            String elongHotelId = gdEbookingEmployeeHotel.getElongHotelId();
            log.info("第{}条日志：获取elongHotelId: {}", logCounter, elongHotelId);

            XdHotel xdHotel = xdHotelMapper.selectByEid(elongHotelId);
            if (xdHotel != null) {
                log.info("第{}条日志：通过eid查询XdHotelName: {}", logCounter, xdHotel.getName());
                Integer hotelId = xdHotel.getId();
                log.info("第{}条日志：获取hotelId: {}", logCounter, hotelId);
                String hotelName = xdHotel.getName();
                log.info("第{}条日志：获取hotelName: {}", logCounter, hotelName);
                log.info("第{}条日志：更新isOpenXdjById成功，hotelId: {}", logCounter, hotelId);
                GdEbookingHotels gdEbookingHotels = gdEbookingHotelsMapper.selectByElongHotelId(elongHotelId);
                if (gdEbookingHotels != null) {
                    log.info("第{}条日志：找到elongHotelId为{}的GdEbookingHotels", logCounter, elongHotelId);
                    XdHotelExpand xdHotelExpand = xdHotelExpandMapper.selectByHid(hotelId.longValue());
                    if (xdHotelExpand != null) {
                        log.info("第{}条日志：找到hid为{}的XdHotelExpand", logCounter, hotelId);
                        List<ShuipfHotelquyuGdHotelYeji> shuipfHotelquyuGdHotelYejis = shuipfHotelquyuGdHotelYejiMapper.selectUseridByEid(elongHotelId);
                        if (!shuipfHotelquyuGdHotelYejis.isEmpty()) {
                            Integer userid = shuipfHotelquyuGdHotelYejis.get(0).getUserid();
                            long getUpdateTimeMillis = gdEbookingHotels.getCreateTime().getTime();
                            long getUpdateTimeSeconds = getUpdateTimeMillis / 1000;
                            if (xdHotelMapper.updateIsOpenXdjAndActivationTimeById(2, (int) getUpdateTimeSeconds, hotelId) > 0) {
                                log.info("第{}条日志：获取userid: {}", logCounter, userid);
                                xdHotelExpand.setAid(userid);
                                log.info("第{}条日志：设置XdHotelExpand的aid: {}", logCounter, userid);
                                xdHotelExpand.setAdjustmentMode(gdEbookingHotels.getCooperationType() == 0 ? 3 : gdEbookingHotels.getCooperationType());
                                log.info("第{}条日志：设置XdHotelExpand的adjustmentMode: {}", logCounter, gdEbookingHotels.getCooperationType());
                                xdHotelExpand.setConfirmaMode(gdEbookingHotels.getAutoConfirmOrder() == 1 ? 2 : 1);
                                log.info("第{}条日志：设置XdHotelExpand的confirmaMode: {}", logCounter, gdEbookingHotels.getAutoConfirmOrder() == 1 ? 2 : 1);
                                xdHotelExpand.setGid(gdEbookingHotels.getGdHotelId());
                                log.info("第{}条日志：设置XdHotelExpand的gid: {}", logCounter, gdEbookingHotels.getGdHotelId());
                                BigDecimal commissionRate = gdEbookingHotels.getCommissionRate();
                                log.info("第{}条日志：获取commissionRate: {}", logCounter, commissionRate);
                                // 将 BigDecimal 转换为 double
                                double commissionRateDouble = commissionRate.doubleValue();
                                log.info("第{}条日志：将commissionRate转换为double: {}", logCounter, commissionRateDouble);
                                // 将值乘以100
                                BigDecimal result = new BigDecimal(commissionRateDouble * 100);
                                log.info("第{}条日志：将commissionRate乘以100: {}", logCounter, result);
                                // 设置保留2位小数，使用四舍五入
                                result = result.setScale(2, RoundingMode.HALF_UP);
                                log.info("第{}条日志：将commissionRate保留2位小数: {}", logCounter, result);
                                xdHotelExpand.setExpandBrokerage(result);
                                log.info("第{}条日志：设置XdHotelExpand的expandBrokerage: {}", logCounter, result);
                                if (xdHotelExpandMapper.updateAidAndAdjustmentModeAndConfirmaModeAndGidAndExpandBrokerageById(
                                        xdHotelExpand.getAid(),
                                        xdHotelExpand.getAdjustmentMode(),
                                        xdHotelExpand.getConfirmaMode(),
                                        xdHotelExpand.getGid(),
                                        xdHotelExpand.getExpandBrokerage(),
                                        xdHotelExpand.getId()
                                ) > 0) {
                                    log.info("第{}条日志：通过id更新XdHotelExpand成功: {}", logCounter, xdHotelExpand.getId());
                                } else {
                                    log.info("第{}条日志：通过id更新XdHotelExpand失败: {}", logCounter, xdHotelExpand.getId());
                                }
                            }
                        } else {
                            log.info("第{}条日志：未找到ShuipfHotelquyuGdHotelYeji数据", logCounter);
                        }
                    }
                }
            }
            logCounter++; // 每次循环结束后递增计数器
        }
    }

}
