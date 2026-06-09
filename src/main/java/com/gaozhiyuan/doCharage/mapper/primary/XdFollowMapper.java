package com.gaozhiyuan.doCharage.mapper.primary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.XdFollow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【xd_follow(跟进记录)】的数据库操作Mapper
* @createDate 2025-02-14 17:56:04
* @Entity com.gaozhiyuan.doCharage.model.XdFollow
*/
public interface XdFollowMapper extends BaseMapper<XdFollow> {
    List<XdFollow> selectById(@Param("id") Integer id);
}




