package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 跟进记录
 * xd_follow
 */
@TableName(value ="xd_follow")
@Data
public class XdFollow {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 项目id
     */
    private Integer pid;

    /**
     * 酒店ID
     */
    private Integer hid;

    /**
     * 公司id
     */
    private Integer cid;

    /**
     * 跟进人ID
     */
    private Integer aid;

    /**
     * 团队名称
     */
    private String teamNames;

    /**
     * 跟进方式（1-电话，2-微信，3-拜访）
     */
    private Integer followType;

    /**
     * 跟进状态（1-待跟进，2-跟进中，3-已成交，4-再次提交，5-已放弃，6-已作废）
     */
    private Integer status;

    /**
     * 跟进意向（1-暂无意向，2-C(低意向)，3-B(中意向), 4-A(高意向)）
     */
    private Integer intention;

    /**
     * 酒店联系人
     */
    private String contactName;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 跟进内容
     */
    private String content;

    /**
     * 跟进提醒
     */
    private Integer followWarnTime;

    /**
     * 是否删除 1-否 ，2-是
     */
    private Integer isDelete;

    /**
     * 是否已经提醒 1-提醒  0-未提醒
     */
    private Integer isWarned;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 修改时间
     */
    private Integer alterTime;
}