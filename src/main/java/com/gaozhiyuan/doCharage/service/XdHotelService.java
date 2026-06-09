package com.gaozhiyuan.doCharage.service;

import com.gaozhiyuan.doCharage.model.XdHotel;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【xd_hotel(酒店基础表)】的数据库操作Service
* @createDate 2025-02-13 09:36:43
*/
public interface XdHotelService extends IService<XdHotel> {
    List<XdHotel> selectHotelBusinessIdAndTmpByHotelBusinessIdAndTmp(Integer hotelBrandId, Integer tmp);
    boolean updateHotel(XdHotel xdHotel);
}
