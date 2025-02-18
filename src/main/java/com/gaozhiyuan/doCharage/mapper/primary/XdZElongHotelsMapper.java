package com.gaozhiyuan.doCharage.mapper.primary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.XdZElongHotels;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【xd_z_elong_hotels】的数据库操作Mapper
* @createDate 2025-02-18 16:07:14
* @Entity com.gaozhiyuan.doCharage.model.XdZElongHotels
*/
public interface XdZElongHotelsMapper extends BaseMapper<XdZElongHotels> {
    List<XdZElongHotels> selectByIdAndBusinessZone(@Param("id") String id, @Param("businessZone") String businessZone);

    XdZElongHotels selectIdAndBusinessZoneById(@Param("id") String id);

    /**
     * 根据ID查询酒店的基本信息，包括ID、星级、品牌ID、开业日期、装修日期、商业区域和酒店类型。
     *
     * @return XdZElongHotels 包含酒店基本信息的对象
     */
    XdZElongHotels selectIdAndCategoryAndBrandIdAndEstablishmentDateAndRenovationDateAndBusinessZoneAndHoteltypesById(@Param("id") String id);

}




