package com.gaozhiyuan.doCharage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gaozhiyuan.doCharage.service.LcElongHotelsService;
import com.gaozhiyuan.doCharage.mapper.secondary.LcElongHotelsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gaozhiyuan.doCharage.model.LcElongHotels;

import java.util.List;

/**
* @author Administrator
* @description 针对表【lc_elong_hotels】的数据库操作Service实现
* @createDate 2025-02-13 09:25:25
*/
@Service
public class LcElongHotelsServiceImpl extends ServiceImpl<LcElongHotelsMapper, LcElongHotels>
    implements LcElongHotelsService{

    @Autowired
    private LcElongHotelsMapper lcElongHotelsMapper;

    public List<LcElongHotels> selectByIdAndBusinessZone(String id, String businessZone) {
        return lcElongHotelsMapper.selectByIdAndBusinessZone(id, businessZone);
    }
}




