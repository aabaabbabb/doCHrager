package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 酒店基础表
 * @TableName xd_hotel
 */
@TableName(value ="xd_hotel")
@Data
public class XdHotel {
    /**
     * 酒店id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 艺龙id
     */
    private String eid;

    /**
     * 住哪id
     */
    private Integer zid;

    /**
     * 酒店名称
     */
    private String name;

    /**
     * 酒店地址
     */
    private String address;

    /**
     * 城市id
     */
    private String cityId;

    /**
     * 酒店电话
     */
    private String tel;

    /**
     * 酒店房间数
     */
    private Integer roomTotal;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 佣金比例
     */
    private BigDecimal commissionRate;

    /**
     * 是否删除
     */
    private Object isDelete;

    /**
     * 是否为艺龙,0-是艺龙产品,1-非艺龙产品
     */
    private Object isElong;

    /**
     * 状态,0-有效,1-无效,2-删除
     */
    private Object status;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 开票方式,1-酒店开票,2-cp提供发票
     */
    private Object invoiceModel;

    /**
     * 代理电话
     */
    private String dltel;

    /**
     * 代理名称
     */
    private String dlname;

    /**
     * 是否开通小店家1-未开通 2-已开通
     */
    private Object isOpenXdj;

    /**
     * 开通时间
     */
    private Integer activationTime;

    /**
     * 高德推广(1-推广，0-不推广)
     */
    private Object gdExtend;

    /**
     * 运营模式1-自运营,2-代运营
     */
    private Object pattern;

    /**
     * 酒店商圈id
     */
    private Integer hotelBusinessId;

    /**
     * 酒店类型id
     */
    private String hotelCategoryId;

    /**
     * 酒店品牌id
     */
    private Integer hotelBrandId;

    /**
     * 酒店星级id
     */
    private Integer hotelStarId;

    /**
     * 携程评分
     */
    private String xcScore;

    /**
     * 艺龙评分
     */
    private String elScore;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 修改时间
     */
    private Integer alterTime;

    /**
     * token
     */
    private String token;

    /**
     * 传真
     */
    private String fax;

    /**
     * 扩展表状态,1-未完成,2-已完成。默认未完成
     */
    private Object expandStatus;

    /**
     * 前台电话
     */
    private String receptionPhone;

    /**
     * 前台电话2
     */
    private String receptionPhoneAgain;

    /**
     * 开业时间
     */
    private String startBusinessTime;

    /**
     * 装修时间
     */
    private String fitmentTime;

    /**
     * 高德二维码
     */
    private String gdQrCode;

    /**
     * 评论数
     */
    private Integer commentTotal;

    /**
     * 代理id
     */
    private Integer dlid;

    /**
     * 签约人ID
     */
    private Integer aid;

    /**
     * 
     */
    private Integer tmp;

    private Integer isUpdate;
}