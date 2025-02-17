package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName xd_zoo_table
 */
@TableName(value ="xd_zoo_table")
@Data
public class XdZooTable {
    /**
     * 
     */
    private Integer uuid;

    /**
     * 
     */
    private Integer userid;

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
    private Long eid;

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
    private Integer curuserid;

    /**
     * 
     */
    private Integer updatetime;

    /**
     * 
     */
    private Integer zid;

    /**
     * 
     */
    private Integer createtimelost;

    /**
     * 
     */
    private String syncxdj;

    /**
     * 
     */
    private String ordercount;

    /**
     * 
     */
    private Integer daoru;
}