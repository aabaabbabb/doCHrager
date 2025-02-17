package com.gaozhiyuan.doCharage.mapper.primary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.XdAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【xd_admin(后台用户表)】的数据库操作Mapper
* @createDate 2025-02-14 16:49:32
* @Entity com.gaozhiyuan.doCharage.model.XdAdmin
*/
public interface XdAdminMapper extends BaseMapper<XdAdmin> {
    XdAdmin selectById(@Param("id") Integer id);
}




