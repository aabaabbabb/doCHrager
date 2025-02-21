package com.gaozhiyuan.doCharage.mapper.primary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.ShuipfHotelquyuGdHotelYeji;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【shuipf_hotelquyu_gd_hotel_yeji】的数据库操作Mapper
* @createDate 2025-02-21 21:41:20
* @Entity com.gaozhiyuan.doCharage.model.ShuipfHotelquyuGdHotelYeji
*/
public interface ShuipfHotelquyuGdHotelYejiMapper extends BaseMapper<ShuipfHotelquyuGdHotelYeji> {
    List<ShuipfHotelquyuGdHotelYeji> selectUseridByEid(@Param("eid") String eid);
}




