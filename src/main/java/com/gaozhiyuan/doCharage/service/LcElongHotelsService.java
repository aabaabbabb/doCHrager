package com.gaozhiyuan.doCharage.service;

import com.gaozhiyuan.doCharage.model.LcElongHotels;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【lc_elong_hotels】的数据库操作Service
* @createDate 2025-02-13 09:25:25
*/
public interface LcElongHotelsService extends IService<LcElongHotels> {
    List<LcElongHotels> selectByIdAndBusinessZone(String id, String businessZone);
    }
