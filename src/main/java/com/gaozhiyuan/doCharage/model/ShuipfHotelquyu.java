package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * shuipf_hotelquyu
 */
@TableName(value ="shuipf_hotelquyu")
@Data
public class ShuipfHotelquyu {
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
     * 
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
    private Integer hotelid;

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
     * 
     */
    private Integer source;

    /**
     * 
     */
    private Integer isUpdate;

    /**
     *
     */
    private Integer isImport;

}