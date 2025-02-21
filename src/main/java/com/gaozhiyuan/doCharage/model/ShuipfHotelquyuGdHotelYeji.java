package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName shuipf_hotelquyu_gd_hotel_yeji
 */
@TableName(value ="shuipf_hotelquyu_gd_hotel_yeji")
@Data
public class ShuipfHotelquyuGdHotelYeji {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer userid;

    /**
     * 
     */
    private Integer hide;

    /**
     * 
     */
    private Integer userpid;

    /**
     * 
     */
    private Integer createtime;

    /**
     * 
     */
    private String hotelname;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private String cityname;

    /**
     * 
     */
    private String bak;

    /**
     * 
     */
    private Integer lianxiuserid;

    /**
     * 
     */
    private Integer updatetime;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private String eid;

    /**
     * 开始日期
     */
    private String tm1;

    /**
     * 
     */
    private String tm2;

    /**
     * 订单属性
     */
    private Integer attr;

    /**
     * 
     */
    private Integer money;

    /**
     * 广告名称
     */
    private Integer guanggaowei;

    /**
     * 
     */
    private Integer tid;

    /**
     * 
     */
    private String orderid;
}