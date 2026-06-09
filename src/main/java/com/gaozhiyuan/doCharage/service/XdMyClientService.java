package com.gaozhiyuan.doCharage.service;

import com.gaozhiyuan.doCharage.model.XdMyClient;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Administrator
* @description 针对表【xd_my_client(我联系的客户)】的数据库操作Service
* @createDate 2025-02-14 14:05:25
*/
public interface XdMyClientService extends IService<XdMyClient> {
    XdMyClient selectByHid(@Param("hid") Integer hid);
    boolean insertAll(XdMyClient xdMyClient);
}
