package com.gaozhiyuan.doCharage.mapper.primary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.XdHotel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【xd_hotel(酒店基础表)】的数据库操作Mapper
* @createDate 2025-02-13 09:36:43
* @Entity com.gaozhiyuan.doCharage.model.XdHotel
*/
public interface XdHotelMapper extends BaseMapper<XdHotel> {
    List<XdHotel> selectHotelBusinessIdAndTmpByHotelBusinessIdAndTmp(@Param("hotelBusinessId") Integer hotelBusinessId, @Param("tmp") Integer tmp);

    List<XdHotel> selectEidAndZidAndNameByZidAndTmp(@Param("zid") Integer zid, @Param("tmp") Integer tmp);

    int updateZidByEid(@Param("zid") Integer zid, @Param("eid") Integer eid);

    XdHotel selectByEid(@Param("eid") Integer eid);

    int updateContactNameAndContactPhoneById(@Param("contactName") String contactName, @Param("contactPhone") String contactPhone, @Param("id") Integer id);
    //AndHotelStarIdAnd
    List<XdHotel> selectByHotelBusinessIdAndTmp(@Param("hotelBusinessId") Integer hotelBusinessId, @Param("tmp") Integer tmp);

    int updateHotelBusinessIdById(@Param("hotelBusinessId") Integer hotelBusinessId, @Param("id") Integer id);
}




