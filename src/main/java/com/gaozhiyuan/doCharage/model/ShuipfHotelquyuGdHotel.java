package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName shuipf_hotelquyu_gd_hotel
 */
@TableName(value ="shuipf_hotelquyu_gd_hotel")
@Data
public class ShuipfHotelquyuGdHotel {
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
    private String cityid;

    /**
     * 
     */
    private String ecityid;

    /**
     * 
     */
    private String telphone;

    /**
     * 
     */
    private String eid;

    /**
     * 
     */
    private String pinyin;

    /**
     * 
     */
    private String py;

    /**
     * 
     */
    private String lat;

    /**
     * 
     */
    private String lng;

    /**
     * 
     */
    private String jingliname;

    /**
     * 
     */
    private String jinglitel;

    /**
     * 
     */
    private String bak;

    /**
     * 销售ID
     */
    private Integer curuserid;

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
    private Integer zid;

    /**
     * 
     */
    private Integer timerday;

    /**
     * 
     */
    private String timer;

    /**
     * 
     */
    private Integer createtimelost;

    /**
     * 类型
     */
    private Integer source;

    /**
     * 
     */
    private BigDecimal price;

    /**
     * 
     */
    private Integer syncxdj;

    /**
     * 
     */
    private Integer trace;

    /**
     * 
     */
    private Integer youzouid;

    /**
     * 
     */
    private Integer ordercount;

    /**
     * 
     */
    private Integer ordercanclecount;

    /**
     * 
     */
    private Integer ordercountupdate;

    /**
     * 
     */
    private Integer hsource;

    /**
     * 
     */
    private Integer sellstatus;

    /**
     * 
     */
    private Integer viewcount;

    /**
     * 
     */
    private Integer viewcountuptime;

    /**
     * 
     */
    private Integer viewcountorder;
    /**
     * 类型
     */
    private Integer isUpdate;

}