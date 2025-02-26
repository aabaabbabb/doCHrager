package com.gaozhiyuan.doCharage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gaozhiyuan.doCharage.model.ShuipfHotelquyuGdHotelYeji;
import com.gaozhiyuan.doCharage.service.ShuipfHotelquyuGdHotelYejiService;
import com.gaozhiyuan.doCharage.mapper.primary.ShuipfHotelquyuGdHotelYejiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Administrator
* @description 针对表【shuipf_hotelquyu_gd_hotel_yeji】的数据库操作Service实现
* @createDate 2025-02-21 21:41:20
*/
@Service
public class ShuipfHotelquyuGdHotelYejiServiceImpl extends ServiceImpl<ShuipfHotelquyuGdHotelYejiMapper, ShuipfHotelquyuGdHotelYeji>
    implements ShuipfHotelquyuGdHotelYejiService{

    @Autowired
    private ShuipfHotelquyuGdHotelYejiMapper shuipfHotelquyuGdHotelYejiMapper;

    @Override
    public List<ShuipfHotelquyuGdHotelYeji> LselectUseridByEid(String eid) {
        return shuipfHotelquyuGdHotelYejiMapper.selectUseridByEid(eid);
    }
}




