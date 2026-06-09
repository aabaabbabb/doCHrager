package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 我联系的客户
 * @TableName xd_my_client
 */
@TableName(value ="xd_my_client")
@Data
public class XdMyClient {
    /**
     * ID
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
     * 项目id
     */
    private Integer pid;

    /**
     * 团队id
     */
    private Integer tid;

    /**
     * 团队名称
     */
    private String teamNames;

    /**
     * 跟进人ID
     */
    private Integer aid;

    /**
     * 跟进状态（1-待跟进）
     */
    private Integer status;

    /**
     * 0-掉到公海客户 1-我联系的客户 2-我的私海客户， 3-我成交的客户
     */
    private Integer type;

    /**
     * 导入时间
     */
    private Integer importTime;

    /**
     * 掉入公海时间配合type=0一起使用
     */
    private Integer outTime;

    /**
     * 添加私海时间
     */
    private Integer privSeaTime;

    /**
     * 掉出私海时间
     */
    private Integer outPrivSeaTime;

    /**
     * 私海锁定时长
     */
    private Integer duration;

    /**
     * 最后跟进记录id
     */
    private Integer lastFid;

    /**
     * 成交时间（跟type=3配合使用）
     */
    private Integer dealTime;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 修改时间
     */
    private Integer alterTime;
}