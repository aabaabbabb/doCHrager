package com.gaozhiyuan.doCharage.mapper.primary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.XdTeam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【xd_team(团队管理表)】的数据库操作Mapper
* @createDate 2025-02-14 16:54:30
* @Entity com.gaozhiyuan.doCharage.model.XdTeam
*/
public interface XdTeamMapper extends BaseMapper<XdTeam> {
    XdTeam selectById(@Param("id") Integer id);
}




