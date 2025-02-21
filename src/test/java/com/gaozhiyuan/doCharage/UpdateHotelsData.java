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
    public void executionTest(){
//        List<ShuipfHotelquyuGdHotelYeji> shuipfHotelquyuGdHotelYejis = shuipfHotelquyuGdHotelYejiMapper.selectUseridByEid("18082899");
//        Integer userid = shuipfHotelquyuGdHotelYejis.get(0).getUserid();
//        System.out.println(userid);

//        List<GdEbookingEmployeeHotel> gdEbookingEmployeeHotels = queryData();
//        // 更新数据
//        doUpdate(gdEbookingEmployeeHotels);
//        log.info("更新结束");
    }

    private List<GdEbookingEmployeeHotel> queryData(){
        log.info("开始查询数据");
        // 获取数据
        List<Integer> roleIdList = new ArrayList<>();
        roleIdList.add(3);
        roleIdList.add(4);

        List<GdEbookingEmployeeHotel> gdEbookingEmployeeHotels = gdEbookingEmployeeHotelMapper.selectElongHotelIdByRoleIdIn(roleIdList);

        log.info("结束查询数据条数：{}", gdEbookingEmployeeHotels.size());
        return gdEbookingEmployeeHotels;
    }

    private  void doUpdate(List<GdEbookingEmployeeHotel> dataList){

        for (GdEbookingEmployeeHotel gdEbookingEmployeeHotel : dataList) {
            String elongHotelId = gdEbookingEmployeeHotel.getElongHotelId();

            XdHotel xdHotel = xdHotelMapper.selectByEid(elongHotelId);
            if(xdHotel == null) {
                Integer hotelId = xdHotel.getId();
                String hotelName = xdHotel.getName();
                if (xdHotelMapper.updateIsOpenXdjById(2, hotelId) > 0) {
                    GdEbookingHotels gdEbookingHotels = gdEbookingHotelsMapper.selectByElongHotelId(elongHotelId);
                    if (gdEbookingHotels != null) {
                        XdHotelExpand xdHotelExpand = xdHotelExpandMapper.selectByHid(hotelId.longValue());
                        if (xdHotelExpand != null){
                            List<ShuipfHotelquyuGdHotelYeji> shuipfHotelquyuGdHotelYejis = shuipfHotelquyuGdHotelYejiMapper.selectUseridByEid(elongHotelId);
                            Integer userid = shuipfHotelquyuGdHotelYejis.get(0).getUserid();
                        }

                       // hotelId

                        if (hotelId > 0) {
                            log.info("hotelId：{}---酒店名称：{}---数据更新成功", hotelId,hotelName);
                        } else {
                            log.info("hotelId：{}---酒店名称：{}---数据更新失败", hotelId,hotelName);
                        }
                    }
                }
            }
        }
    }


}
