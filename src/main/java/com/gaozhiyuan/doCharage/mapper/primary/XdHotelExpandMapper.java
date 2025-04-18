package com.gaozhiyuan.doCharage.mapper.primary;
import java.math.BigDecimal;
import java.util.List;

import com.gaozhiyuan.doCharage.model.XdMyClient;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.XdHotelExpand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【xd_hotel_expand(酒店扩展包)】的数据库操作Mapper
* @createDate 2025-02-21 20:59:34
* @Entity com.gaozhiyuan.doCharage.model.XdHotelExpand
*/
public interface XdHotelExpandMapper extends BaseMapper<XdHotelExpand> {
    XdHotelExpand selectByHid(@Param("hid") Long hid);

    int updateAidAndAdjustmentModeAndConfirmaModeAndGidAndExpandBrokerageById(@Param("aid") Integer aid, @Param("expandBrokerage") BigDecimal expandBrokerage,@Param("tid") Integer tid, @Param("id") Integer id);

    int insertAll(@Param("list") List<XdHotelExpand> list);

}




