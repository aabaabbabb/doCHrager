package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 项目管理表
 * @TableName xd_project
 */
@TableName(value ="xd_project")
@Data
public class XdProject {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目状态（1-禁用，2-启用）
     */
    private Object status;

    /**
     * 最低充值金额
     */
    private BigDecimal minRechargePrice;

    /**
     * 是否显示删除（1-否，0-是）
     */
    private Object isDeleted;

    /**
     * 排序
     */
    private Integer sortOrder;

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
}