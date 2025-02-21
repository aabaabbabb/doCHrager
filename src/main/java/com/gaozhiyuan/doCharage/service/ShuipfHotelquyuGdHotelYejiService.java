package com.gaozhiyuan.doCharage.service;

import com.gaozhiyuan.doCharage.model.ShuipfHotelquyuGdHotelYeji;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【shuipf_hotelquyu_gd_hotel_yeji】的数据库操作Service
* @createDate 2025-02-21 21:41:20
*/
public interface ShuipfHotelquyuGdHotelYejiService extends IService<ShuipfHotelquyuGdHotelYeji> {
    public List<ShuipfHotelquyuGdHotelYeji> LselectUseridByEid(String eid);
}
