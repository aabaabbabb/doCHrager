package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 收款账户表
 * xd_receiving_account
 */
@TableName(value ="xd_receiving_account")
/**
 * @EqualsAndHashCode注解会自动为类生成equals()和hashCode()方法。
 * equals()方法用于比较对象是否相等，hashCode()方法用于为对象生成哈希值，通常用于集合类（如HashSet、HashMap）中判断对象是否相等或存储对象。
 * 默认情况下，@EqualsAndHashCode会使用类中的所有字段来计算equals()和hashCode()。你也可以通过配置参数来定制哪些字段用于这些方法的计算。
 * @EqualsAndHashCode
 */
@EqualsAndHashCode
/**
 *
 * @RequiredArgsConstructor注解会自动为类中所有**final字段和@NonNull**标注的字段生成一个构造函数。
 * 这个构造函数会包含所有被标记为final的字段，并且会自动进行初始化。@NonNull注解标记的字段也会被加入到构造函数中，以确保它们在对象创建时被初始化。
 * @RequiredArgsConstructor
 */
@RequiredArgsConstructor
@Builder
@Data
@AllArgsConstructor
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