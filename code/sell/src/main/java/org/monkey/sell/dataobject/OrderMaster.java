package org.monkey.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.monkey.sell.enums.OrderStatusEnum;
import org.monkey.sell.enums.PayStatusEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表
 */
@Entity
@Data
@DynamicUpdate
@Table(name = "order_master")
public class OrderMaster {
    
    /** 订单id */
    @Id
    private String orderId;
    /** 买家名字 */
    private String buyerName;
    /** 买家电话 */
    private String buyerPhone;
    /** 买家地址 */
    private String buyerAddress;
    /** 买家微信openid */
    private String buyerOpenid;
    /** 订单总金额 */
    private BigDecimal orderAmount;
    /** 订单状态，默认0，新下单 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /** 支付状态，默认0，未支付 */
    private Integer payStatus = PayStatusEnum.WATI.getCode();
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
