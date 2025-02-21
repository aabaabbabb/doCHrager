package com.gaozhiyuan.doCharage.mapper.primary;
import java.util.List;

import com.gaozhiyuan.doCharage.model.XdCompany;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【xd_company(公司管理表)】的数据库操作Mapper
* @createDate 2025-02-20 13:54:53
* @Entity com.gaozhiyuan.doCharage.model.XdCompany
*/
public interface XdCompanyMapper extends BaseMapper<XdCompany> {
    List<XdCompany> selectAll();
}




