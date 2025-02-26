package com.gaozhiyuan.doCharage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gaozhiyuan.doCharage.model.XdMyClient;
import com.gaozhiyuan.doCharage.service.XdMyClientService;
import com.gaozhiyuan.doCharage.mapper.primary.XdMyClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
* @author Administrator
* @description 针对表【xd_my_client(我联系的客户)】的数据库操作Service实现
* @createDate 2025-02-14 14:05:25
*/
@Service
public class XdMyClientServiceImpl extends ServiceImpl<XdMyClientMapper, XdMyClient>
    implements XdMyClientService{

    @Autowired
    private XdMyClientMapper xdMyClientMapper;

    @Override
    public XdMyClient selectByHid(Integer hid) {
        return xdMyClientMapper.selectByHid(hid);
    }

    @Override
    public boolean insertAll(XdMyClient xdMyClient) {
        return this.save(xdMyClient);
    }
}




