package com.gaozhiyuan.doCharage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 酒店扩展包
 * @TableName xd_hotel_expand
 */
@TableName(value ="xd_hotel_expand")
@Data
public class XdHotelExpand {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 酒店id
     */
    private Long hid;

    /**
     * 同程id
     */
    private Long tcid;

    /**
     * 百度id
     */
    private Long bid;

    /**
     * 盛途id
     */
    private Long sid;

    /**
     * 携程id
     */
    private Long xid;

    /**
     * 高德id
     */
    private Long gid;

    /**
     * 飞猪id
     */
    private Long fid;

    /**
     * 合作模式（1-抽佣模式， 2-抽佣模式2(酒店不可调价，奈斯代调)，3-底价模式(以固定底价和酒店结算)）
     */
    private Object cooperation;

    /**
     * 调价模式（1-自调价， 2-代调价，3-低价模式）
     */
    private Object adjustmentMode;

    /**
     * 订单确认方式（1-手动确认订单， 2-自动确认订单）
     */
    private Object confirmaMode;

    /**
     * 开票方式（1-酒店给客人开发票，2-平台给客人开发票）
     */
    private Object invoicingMode;

    /**
     * 机器人KEY
     */
    private String robotKey;

    /**
     * 运营人ID
     */
    private Integer operatorId;

    /**
     * 最低充值金额
     */
    private BigDecimal minPrice;

    /**
     * 渠道及佣金ID
     */
    private Integer canalBrokerageId;

    /**
     * 结算对象 （1-结算给酒店，2-结算给代理）
     */
    private Object settlementRole;

    /**
     * 业务对接人
     */
    private String contactPerson;

    /**
     * 对接人手机
     */
    private String contactPhone;

    /**
     * 紧急订单处理电话
     */
    private String emergencyPhone;

    /**
     * 营业执照/合同URL
     */
    private String imgUrl;

    /**
     * 发票抬头
     */
    private String invoiceTitle;

    /**
     * 统一税号
     */
    private String taxNumber;

    /**
     * 接受发票手机
     */
    private String invoicePhone;

    /**
     * 接受发票邮箱
     */
    private String invoiceEmail;

    /**
     * 酒店可显示的小店家菜单
     */
    private String xdjMenus;

    /**
     * 渠道佣金
     */
    private BigDecimal expandBrokerage;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 修改时间
     */
    private Integer alterTime;

    /**
     * 签约人ID
     */
    private Integer aid;

    /**
     * 团队ID
     */
    private Integer tid;

    /**
     * 酒店运营主体
     */
    private String hotelOperator;

    /**
     * 酒店账户余额
     */
    private BigDecimal balance;

    /**
     * 代理id
     */
    private Integer dlid;

    /**
     * 是否弹窗 1-不弹窗提示 2-弹窗提示
     */
    private Integer isDialog;

    /**
     * 订单是否声音提示 1-不开声音提示，2-开启声音提示
     */
    private Integer isSoundPrompt;

    /**
     * 备注
     */
    private String memo;
}