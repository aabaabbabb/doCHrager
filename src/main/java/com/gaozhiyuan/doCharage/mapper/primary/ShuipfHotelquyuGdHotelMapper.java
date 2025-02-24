package com.gaozhiyuan.doCharage.mapper.primary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.ShuipfHotelquyuGdHotel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【shuipf_hotelquyu_gd_hotel】的数据库操作Mapper
* @createDate 2025-02-24 16:52:09
* @Entity com.gaozhiyuan.doCharage.model.ShuipfHotelquyuGdHotel
*/
public interface ShuipfHotelquyuGdHotelMapper extends BaseMapper<ShuipfHotelquyuGdHotel> {
    List<ShuipfHotelquyuGdHotel> selectByUpdatetimeAndIsUpdate(@Param("updatetime") Integer updatetime, @Param("isUpdate") Integer isUpdate);

    List<ShuipfHotelquyuGdHotel> selectByUpdatetimeBetweenAndIsUpdate(@Param("beginUpdatetime") Integer beginUpdatetime, @Param("endUpdatetime") Integer endUpdatetime, @Param("isUpdate") Integer isUpdate);

    int updateIsUpdateById(@Param("isUpdate") Integer isUpdate, @Param("id") Integer id);
}




