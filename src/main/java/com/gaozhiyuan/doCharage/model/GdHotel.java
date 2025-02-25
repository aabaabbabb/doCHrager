package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName gd_hotel
 */
@TableName(value ="gd_hotel")
@Data
public class GdHotel {
    /**
     * 高德酒店ID
     */
    @TableId
    private Long id;

    /**
     * 此字段隐藏，不需要处理
     */
    private Integer tailnum;

    /**
     * 艺龙酒店id
     */
    private String elongid;

    /**
     * 酒店中文名称
     */
    private String hotelname;

    /**
     * 酒店状态 0:有效 1:无效 2:删除
     */
    private Integer hotelstatus;

    /**
     * 挂牌星级
     */
    private Integer starrate;

    /**
     * 艺龙推荐星级
     */
    private Integer category;

    /**
     * 电话
     */
    private String phone;

    /**
     * 品牌中文名称
     */
    private String brandname;

    /**
     * 高德纬度
     */
    private String gaodelat;

    /**
     * 高德经度
     */
    private String gaodelon;

    /**
     * Baidu纬度
     */
    private String baidulat;

    /**
     * Baidu经度
     */
    private String baidulon;

    /**
     * 主城市Id
     */
    private String cityid;

    /**
     * 城市中文名
     */
    private String cityname;

    /**
     * 客房总数量
     */
    private Integer roomtotalamount;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private Integer hoteltype;

    /**
     * 
     */
    private String elongidstr;

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
    private String dltel;

    /**
     * 
     */
    private String dlname;

    /**
     * 1 下架
     */
    private Integer down;

    /**
     * 1 是更新不到接口房态
     */
    private Integer noroom;

    /**
     * 佣金比例
     */
    private BigDecimal commissionRate;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 1=酒店开票,2=CP提供发票
     */
    private Integer invoicemode;

    /**
     * 0是艺龙产品，1是非艺龙
     */
    private Integer source;

    /**
     * 
     */
    private Integer offline;

    /**
     * 百度id
     */
    private Long baiduid;

    /**
     * 写入数据库时间
     */
    private Date created;
}