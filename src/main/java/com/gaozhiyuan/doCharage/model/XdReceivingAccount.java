package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 收款账户表
 * @TableName xd_receiving_account
 */
@TableName(value ="xd_receiving_account")
@Data
public class XdReceivingAccount {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 酒店ID
     */
    private Integer hid;

    /**
     * 公司id
     */
    private Integer cid;

    /**
     * 账户类型，值：1-银行, 2-支付宝
     */
    private Integer accountType;

    /**
     * 收款账户名称
     */
    private String accountName;

    /**
     * 开户行名称
     */
    private String bankName;

    /**
     * 开户行省份
     */
    private String province;

    /**
     * 开户支行名称
     */
    private String branchName;

    /**
     * 账号
     */
    private String accountNumber;

    /**
     * 卡类型（借记卡/信用卡）
     */
    private String cardType;

    /**
     * 创建时间（时间戳）
     */
    private Integer createTime;

    /**
     * 更新时间（时间戳）
     */
    private Integer alterTime;
}