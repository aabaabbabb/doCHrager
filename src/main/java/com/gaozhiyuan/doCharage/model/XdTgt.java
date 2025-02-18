package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName xd_tgt
 */
@TableName(value ="xd_tgt")
@Data
public class XdTgt {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 酒店名称
     */
    private String hotelName;

    /**
     * 艺龙id
     */
    private Integer eid;

    /**
     * 门店id
     */
    private String storeouterid;

    /**
     * 高德poi
     */
    private String gdpoi;

    /**
     * 录入时间
     */
    private Integer createTime;

    /**
     * 修改时间
     */
    private Integer alterTime;

    /**
     * 推广充值总额
     */
    private BigDecimal promotionBalance;
}