package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 团队管理表
 * xd_team
 */
@TableName(value ="xd_team")
@Data
public class XdTeam {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 团队名称
     */
    private String name;

    /**
     * 团队状态（1-禁用，2-启用）
     */
    private Object status;

    /**
     * 是否删除（1-否，0-是）
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
     * 所属项目ID
     */
    private Integer projId;

    /**
     * 客户锁定时长
     */
    private Integer publicDuration;

    /**
     * 私海客户数量
     */
    private Integer privateCount;

    /**
     * 掉出惩罚时间
     */
    private Integer dropoutTime;

    /**
     * 跟进记录字数
     */
    private Integer recordLength;

    /**
     * 公司ID
     */
    private Integer cid;

    /**
     * 备注
     */
    private String memo;

    /**
     * 是否删除（1-否，2-是）
     */
    private Object isDelete;
}