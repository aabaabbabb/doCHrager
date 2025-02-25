package com.gaozhiyuan.doCharage.mapper.primary;
import java.util.List;

import com.gaozhiyuan.doCharage.model.GdHotel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【gd_hotel】的数据库操作Mapper
* @createDate 2025-02-24 21:21:07
* @Entity com.gaozhiyuan.doCharage.model.GdHotel
*/
public interface GdHotelMapper extends BaseMapper<GdHotel> {
    List<GdHotel> selectALl();
}




