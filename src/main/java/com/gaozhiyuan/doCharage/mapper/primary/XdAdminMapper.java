package com.gaozhiyuan.doCharage.mapper.primary;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.XdAdmin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【xd_admin(后台用户表)】的数据库操作Mapper
* @createDate 2025-02-25 09:30:34
* @Entity com.gaozhiyuan.doCharage.model.XdAdmin
*/
public interface XdAdminMapper extends BaseMapper<XdAdmin> {
    int updatePasswordById(@Param("password") String password, @Param("id") Integer id);
}




