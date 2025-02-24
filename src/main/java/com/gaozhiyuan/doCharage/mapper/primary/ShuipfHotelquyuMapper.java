package com.gaozhiyuan.doCharage.mapper.primary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.ShuipfHotelquyu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【shuipf_hotelquyu】的数据库操作Mapper
* @createDate 2025-02-21 15:59:02
* @Entity com.gaozhiyuan.doCharage.model.ShuipfHotelquyu
*/
public interface ShuipfHotelquyuMapper extends BaseMapper<ShuipfHotelquyu> {
    List<ShuipfHotelquyu> selectByIsUpdate(@Param("isUpdate") Integer isUpdate);
    //EidIsNotNull
    List<ShuipfHotelquyu> selectByIsUpdateAndIsImportAndEidIsNotNull(@Param("isUpdate") Integer isUpdate, @Param("isImport") Integer isImport);

    int updateIsImportById(@Param("isImport") Integer isImport, @Param("id") Integer id);

    List<ShuipfHotelquyu> selectByIsImport(@Param("isImport") Integer isImport);
}




