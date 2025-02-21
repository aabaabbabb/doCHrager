package com.gaozhiyuan.doCharage.mapper.primary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.GdEbookingHotels;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【gd_ebooking_hotels】的数据库操作Mapper
* @createDate 2025-02-21 20:43:21
* @Entity com.gaozhiyuan.doCharage.model.GdEbookingHotels
*/
public interface GdEbookingHotelsMapper extends BaseMapper<GdEbookingHotels> {
    GdEbookingHotels selectByElongHotelId(@Param("elongHotelId") String elongHotelId);
}




