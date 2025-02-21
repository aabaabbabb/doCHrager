package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 员工酒店关系表
 * @TableName gd_ebooking_employee_hotel
 */
@TableName(value ="gd_ebooking_employee_hotel")
@Data
public class GdEbookingEmployeeHotel {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 员工id
     */
    private Integer employeeId;

    /**
     * 酒店id
     */
    private String elongHotelId;

    /**
     * 酒店名称
     */
    private String hotelName;

    /**
     * 角色 目前一个人在所有门店的角色是一致的
     */
    private Integer roleId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否删除 同员工表一起删除
     */
    private Integer isDelete;

    /**
     * 预订人姓名
     */
    private String bookingContactName;

    /**
     * 预订人的话
     */
    private String bookingContactPhone;

    /**
     * 删除时间
     */
    private Date deleteTime;

    /**
     * 最后修改时间
     */
    private Date updateTime;

    /**
     * 佣金比例
     */
    private BigDecimal commissionRate;

    /**
     * 城市ID
     */
    private String cityId;

    /**
     * 城市名称
     */
    private String cityName;
}