package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 后台用户表
 * xd_admin
 */
@TableName(value ="xd_admin")
@Data
public class XdAdmin {
    /**
     * 用户ID, 主键, 自增
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 角色ID
     */
    private Integer rid;

    /**
     * 公司id
     */
    private Integer cid;

    /**
     * 团队ID
     */
    private Integer tid;

    /**
     * 云电话账号
     */
    private String cloudPhone;

    /**
     * 性别，1 -男 ，2-女 ，3- 其他
     */
    private Object gender;

    /**
     * 上次登录时间
     */
    private Integer lastLogin;

    /**
     * 账户状态, 1-禁用, 2-启用
     */
    private Object status;

    /**
     * 备注
     */
    private String memo;

    /**
     * 是否删除, 1-否, 2-是
     */
    private Object isDelete;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 修改时间
     */
    private Integer alterTime;

    /**
     * 密码验证字段
     */
    private String verify;

    /**
     * 管理员头像
     */
    private String face;
}