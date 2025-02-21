package com.gaozhiyuan.doCharage.mapper.primary;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gaozhiyuan.doCharage.model.XdMyClient;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【xd_my_client(我联系的客户)】的数据库操作Mapper
* @createDate 2025-02-14 14:05:25
* @Entity com.gaozhiyuan.doCharage.model.XdMyClient
*/
public interface XdMyClientMapper extends BaseMapper<XdMyClient> {
    XdMyClient selectByHid(@Param("hid") Integer hid);
    int insertAll(@Param("list") List<XdMyClient> list);

    XdMyClient selectByHidAndPid(@Param("hid") Integer hid, @Param("pid") Integer pid);
}




