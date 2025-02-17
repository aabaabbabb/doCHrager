package com.gaozhiyuan.doCharage.mapper.primary;
import java.util.List;

import com.gaozhiyuan.doCharage.model.XdZooTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【xd_zoo_table】的数据库操作Mapper
* @createDate 2025-02-17 10:57:18
* @Entity com.gaozhiyuan.doCharage.model.XdZooTable
*/
public interface XdZooTableMapper extends BaseMapper<XdZooTable> {
    List<XdZooTable> selectAll();
}




