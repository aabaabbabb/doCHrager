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
 * @TableName xd_z_elong_hotels
 */
@TableName(value ="xd_z_elong_hotels")
@Data
public class XdZElongHotels {
    /**
     * 自增ID
     */
    @TableId(type = IdType.AUTO)
    private Integer tid;

    /**
     * 酒店ID
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮编
     */
    private String postalCode;

    /**
     * 挂牌星际
     */
    private Integer starRate;

    /**
     * 艺龙推荐星际
     */
    private Integer category;

    /**
     * 电话
     */
    private String phone;

    /**
     * 传真
     */
    private String fax;

    /**
     * 开业时间
     */
    private String establishmentDate;

    /**
     * 装修时间
     */
    private String renovationDate;

    /**
     * 集团编号
     */
    private Integer groupId;

    /**
     * 品牌ID
     */
    private Integer brandId;

    /**
     * 是否经济型，默认0 ，1 是经济型
     */
    private Integer isEconomic;

    /**
     * 是否公寓 默认0，1是酒店式公寓
     */
    private Integer isApartment;

    /**
     * 入住时间
     */
    private String arrivalTime;

    /**
     * 离店时间
     */
    private String departureTime;

    /**
     * 
     */
    private String products;

    /**
     * 纬度
     */
    private BigDecimal googleLat;

    /**
     * 经度
     */
    private BigDecimal googleLng;

    /**
     * 百度纬度
     */
    private BigDecimal baiduLat;

    /**
     * 百度经度
     */
    private BigDecimal baiduLng;

    /**
     * 主城市
     */
    private String cityId;

    /**
     * 关联城市，逗号分割，可能包含city_id
     */
    private String cityId2;

    /**
     * 行政区
     */
    private String district;

    /**
     * 主商圈 编码
     */
    private String businessZone;

    /**
     * 附属商圈
     */
    private String businessZone2;

    /**
     * 酒店支持的信用卡
     */
    private String creditCards;

    /**
     * 简介
     */
    private String introEditor;

    /**
     * 描述
     */
    private String description;

    /**
     * 接机服务
     */
    private String airportpickupService;

    /**
     * 封面图
     */
    private String cover;

    /**
     * 评论标签2(elong)
     */
    private Object commentTagList;

    /**
     * 评论标签
     */
    private Object tagList;

    /**
     * 设施列表
     */
    private String facilities;

    /**
     * 酒店服务指数
     */
    private String serviceRank;

    /**
     * 酒店设施信息
     */
    private String facilities2;

    /**
     * 酒店房间总数
     */
    private Integer roomTotalAmount;

    /**
     * 服务设施
     */
    private String generalAmenities;

    /**
     * 房间设施
     */
    private String roomAmenities;

    /**
     * 休闲设施
     */
    private String recreationAmenities;

    /**
     * 会议设施
     */
    private String conferenceAmenities;

    /**
     * 餐饮设施
     */
    private String diningAmenities;

    /**
     * 附近交通
     */
    private String nearbyTraffic;

    /**
     * 周边交通
     */
    private String traffic;

    /**
     * 周边信息
     */
    private String surroundings;

    /**
     * 特色信息
     */
    private String features;

    /**
     * 是否允许返现 默认0 ，1 是
     */
    private Integer hasCoupon;

    /**
     * 评分
     */
    private Object review;

    /**
     * 酒店状态
     */
    private Integer status;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer isGet;

    /**
     * 
     */
    private Integer isTag;

    /**
     * 
     */
    private Integer isNearby;

    /**
     * 是否采集封面
     */
    private Integer isCover;

    /**
     * 思客酒店ID
     */
    private Integer skHotelid;

    /**
     * 住哪酒店ID
     */
    private Integer znHotelid;

    /**
     * 携程酒店ID
     */
    private Integer ctrHotelid;

    /**
     * 连锁ID
     */
    private Integer lsid;

    /**
     * 10天是否满房数据
     */
    private String day10;

    /**
     * 状态（0-下线，1-在线，-1删除）
     */
    private Integer statusS;

    /**
     * 评分
     */
    private BigDecimal commentScores;

    /**
     * 评论数量
     */
    private Integer commentCount;

    /**
     * 最低价
     */
    private Integer minPrice;

    /**
     * 最高价
     */
    private Integer maxPrice;

    /**
     * 商圈名称
     */
    private String businessZoneName;

    /**
     * 行政区
     */
    private String districtName;

    /**
     * 国内外酒店(1-国内，2国外)
     */
    private Integer isChina;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 客房数量
     */
    private Integer roomtotalamount;

    /**
     * 酒店类型
     */
    private String hoteltypes;

    /**
     * 是否更新（1-需要更新，0-不需更新）
     */
    private Integer up;

    /**
     * 趣出差合作酒店
     */
    private Integer isMcCooperate;

    /**
     * 趣出差合作时间
     */
    private Date mcCooperateTime;

    /**
     * 收益类型-推荐奖励
     */
    private BigDecimal earningsType1;

    /**
     * 收益类型-订单奖励
     */
    private BigDecimal earningsType2;

    /**
     * 趣出差推广有效距离
     */
    private Integer validDistance;

    /**
     * 扣除百分比
     */
    private Integer deductPercent;

    /**
     * 艺龙状态（0-在售，1-停售）
     */
    private Integer estatus;

    /**
     * 是否更新房态(1-是,0-否)
     */
    private Integer isupdate;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 是否合作酒店(1-是，0-否)
     */
    private Integer isHezuo;

    /**
     * 房型数量
     */
    private Integer hezuoRooms;

    /**
     * 是否隐藏邀请码
     */
    private Integer isHideInvitecode;

    /**
     * 是否思客五大品牌优势酒店(1-是，0-否)
     */
    private Integer isAdvantage;

    /**
     * 收益类型-首单奖励
     */
    private BigDecimal earningsType3;

    /**
     * 收益类型-首单奖励-是否启用
     */
    private Integer earningsType3Enabled;

    /**
     * 账户余额
     */
    private BigDecimal accountMoney;

    /**
     * 评论统计信息
     */
    private Object commentData;

    /**
     * 含早数量（0-不含早，1-单早，2-双早，99-单双早都含）
     */
    private Integer breakfastcount;

    /**
     * 床型(1-大床，2-双床，99-都含)
     */
    private Integer bedtype;

    /**
     * 窗户类型(0-无窗，1-有窗)
     */
    private Integer windowtype;

    /**
     * 景点权益卡ID（,分割）
     */
    private String scenicId;

    /**
     * 封面width
     */
    private BigDecimal coverWidth;

    /**
     * 封面height
     */
    private BigDecimal coverHeight;

    /**
     * 附近交通
     */
    private Object nearbyTrafficInfos;

    /**
     * 
     */
    private Date updatetimes;

    /**
     * 404设置(1-404,0-显示)
     */
    private Integer offline;

    /**
     * 思客原酒店ID
     */
    private Integer skidOld;

    /**
     * 是否有停车场(1-有，0-无)
     */
    private Integer parkingLot;

    /**
     * 是否有会议室(1-有，0-无)
     */
    private Integer meetingRoom;

    /**
     * 停车场
     */
    private Object parkinfos;

    /**
     * 思客资源下线(1-下线,0-显示)
     */
    private Integer skOffline;

    /**
     * 是否有酒店开票（1-是）
     */
    private Integer hasHotelModel;

    /**
     * 国家ID
     */
    private String countryid;

    /**
     * 携程原酒店ID
     */
    private Integer ctrHotelidOld;

    /**
     * 是否优势酒店
     */
    private Integer advantaged;

    /**
     * 是否艺龙酒店（1-是，2-酒店2,3-小店家）
     */
    private Integer isElong;

    /**
     * 是否删除或下架(1-是，0-否)
     */
    private Integer isDelete;

    /**
     * 深捷旅酒店ID
     */
    private Integer sjlHotelid;

    /**
     * 是否推送高德(0-未推，1-已推，2-不推送)
     */
    private Integer isPushGaode;

    /**
     * 1-即时确认
     */
    private Integer instantconfirmation;

    /**
     * 
     */
    private Integer sjlHotSale;

    /**
     * 深捷旅最低价
     */
    private BigDecimal sjlMinPrice;

    /**
     * 深捷旅最高价
     */
    private BigDecimal sjlMaxPrice;

    /**
     * 思客酒店名称
     */
    private String skHotelname;

    /**
     * 思客酒店地址
     */
    private String skHoteladdress;

    /**
     * 思客酒店电话
     */
    private String skHotelphone;
}