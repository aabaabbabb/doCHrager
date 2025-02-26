package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * gd_ebooking_hotels
 */
@TableName(value ="gd_ebooking_hotels")
@Data
public class GdEbookingHotels {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 城市ID
     */
    private String cityId;

    /**
     * 艺龙酒店ID
     */
    private String elongHotelId;

    /**
     * 酒店名称
     */
    private String hotelName;

    /**
     * 佣金比例（高德）
     */
    private BigDecimal commissionRate;

    /**
     * 酒店联系人
     */
    private String contactName;

    /**
     * 酒店联系电话
     */
    private String contactPhone;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 运营模式
     */
    private Integer operationMode;

    /**
     * 合作类型(1-自调价，2-代调价)
     */
    private Integer cooperationType;

    /**
     * 调价模式（1-调底价，2-调卖价）
     */
    private Integer priceAdjustmentMode;

    /**
     * 企业微信群机器人key
     */
    private String companyWeixinGroupRobotKey;

    /**
     * 是否删除(1-是，0-否)
     */
    private Integer isDelete;

    /**
     * 签约人ID
     */
    private Integer signatoryid;

    /**
     * 服务人/售后ID（当前）
     */
    private Integer serviceid;

    /**
     * 签约人姓名
     */
    private String signatoryname;

    /**
     * 服务人/售后人姓名（当前）
     */
    private String servicename;

    /**
     * 佣金比例（酒店合作谈判）
     */
    private BigDecimal cooperateCommissionRate;

    /**
     * 结算周期（1=>T+1，2=>T+2类推）
     */
    private Integer settlementCycle;

    /**
     * 账户余额
     */
    private BigDecimal accountMoney;

    /**
     * 是否自动确认订单（1-是，0-否）
     */
    private Integer autoConfirmOrder;

    /**
     * 推广余额
     */
    private BigDecimal promotionBalance;

    /**
     * 酒店结算余额最后更新时间
     */
    private Date accountMoneyLastUptime;

    /**
     * 酒店地址
     */
    private String address;

    /**
     * 酒店电话
     */
    private String phone;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 代理ID
     */
    private Integer employeeId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 深捷旅酒店ID
     */
    private Integer sjlHotelid;

    /**
     * 高德酒店名称
     */
    private String gdHotelName;

    /**
     * 是否和高德名字一致（1-一致，2-不一致）
     */
    private Integer isGaodeSame;

    /**
     * 高德酒店ID
     */
    private Long gdHotelId;

    /**
     * 高德酒店状态
     */
    private Integer gdStatus;

    /**
     * 是否挂接高德房型
     */
    private Integer isGaodeRoom;

    /**
     * poiid
     */
    private String gdPoiid;

    /**
     * shopAddress
     */
    private String gdAddress;

    /**
     * 
     */
    private Integer serverId;

    /**
     * 0-下线，1-上线
     */
    private Integer gdOnline;

    /**
     * 备注
     */
    private String notes;

    /**
     * 思客酒店ID
     */
    private Integer skHotelid;

    /**
     * 是否有预订系统
     */
    private Integer isHotelEbooking;

    /**
     * 百度酒店ID
     */
    private Long bdHotelId;

    /**
     * 百度坐标
     */
    private Double baiduLat;

    /**
     * 百度坐标
     */
    private Double baiduLng;

    /**
     * 最低价格
     */
    private BigDecimal minPrice;

    /**
     * 最高价格
     */
    private BigDecimal maxPrice;
}