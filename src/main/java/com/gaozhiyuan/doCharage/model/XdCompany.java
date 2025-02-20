package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 公司管理表
 * @TableName xd_company
 */
@TableName(value ="xd_company")
@Data
public class XdCompany {
    /**
     * 公司ID, 主键, 自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 公司负责人ID
     */
    private Integer aid;

    /**
     * 公司状态（1-禁用，2-启用）
     */
    private Object status;

    /**
     * 是否显示删除（1-否，0-是）
     */
    private Object isDeleted;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 修改时间
     */
    private Integer alterTime;

    /**
     * 备注
     */
    private String memo;

    /**
     * 是否删除（1-否，2-是）
     */
    private Object isDelete;

    /**
     * 代理可提现余额
     */
    private BigDecimal balance;
}