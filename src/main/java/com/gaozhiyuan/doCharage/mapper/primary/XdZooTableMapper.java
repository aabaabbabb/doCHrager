package com.gaozhiyuan.doCharage.mapper.primary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.XdZooTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【xd_zoo_table】的数据库操作Mapper
* @createDate 2025-02-17 11:45:47
* @Entity com.gaozhiyuan.doCharage.model.XdZooTable
*/
public interface XdZooTableMapper extends BaseMapper<XdZooTable> {
    List<XdZooTable> selectByDaoru(@Param("daoru") Integer daoru);

    int updateDaoruByUuid(@Param("daoru") Integer daoru, @Param("uuid") Integer uuid);
}




