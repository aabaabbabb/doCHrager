package com.gaozhiyuan.doCharage.mapper.secondary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.LcElongHotels;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【lc_elong_hotels】的数据库操作Mapper
* @createDate 2025-02-13 09:25:25
* @Entity com.gaozhiyuan.doCharage.domain.LcElongHotels
*/
public interface LcElongHotelsMapper extends BaseMapper<LcElongHotels> {
  public  List<LcElongHotels> selectByIdAndBusinessZone(@Param("id") String id, @Param("businessZone") String businessZone);
}




