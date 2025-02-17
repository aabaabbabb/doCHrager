package com.gaozhiyuan.doCharage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gaozhiyuan.doCharage.model.XdHotel;
import com.gaozhiyuan.doCharage.service.XdHotelService;
import com.gaozhiyuan.doCharage.mapper.primary.XdHotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
* @author Administrator
* @description 针对表【xd_hotel(酒店基础表)】的数据库操作Service实现
* @createDate 2025-02-13 09:36:43
*/
@Service
public class XdHotelServiceImpl extends ServiceImpl<XdHotelMapper, XdHotel>
    implements XdHotelService{

    @Autowired
    private XdHotelMapper xdHotelMapper;
    @Override
    public List<XdHotel> selectHotelBusinessIdAndTmpByHotelBusinessIdAndTmp(Integer hotelBrandId, Integer tmp) {
        return xdHotelMapper.selectHotelBusinessIdAndTmpByHotelBusinessIdAndTmp(hotelBrandId, tmp);
    }

    @Override
    public boolean updateHotel(XdHotel xdHotel) {
        return this.updateById(xdHotel);
    }
}




