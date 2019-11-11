package org.ly817.sparrow.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * order
 *
 * @author
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {
    private Long orderId;

    private String paySerialId;

    private Long userId;

    private Integer number;

    private Double amount;

    public static int ORDER_NO_CONFIRM = 0;//订单未确认
    public static int ORDER_CONFIRM = 1;//订单已确认
    public static int ORDER_CANCEL = 2;//订单已取消
    public static int ORDER_INVALID = 3; //订单无效
    public static int ORDER_RETURNED = 4;//订单已退货
    public static int ORDER_FINISHED = 5;//订单已完成
    public static int ORDER_CALL_ERROR = 6; //订单异常

    /**
     * 0 未确定 1 已确定 2已取消 3无效 4退款
     */
    private Integer orderSts;

    /**
     * 0 未支付 1 支付中 2 已支付
     */
    private Integer paySts;

    /**
     * 0 未发货 1 已发货 2 已退货
     */
    private Integer shippingSts;

    private String address;

    private String consignee;

    private Long productId;

    private Integer productNumber;

    private BigDecimal productPrice;

    private BigDecimal productAmount;

    private BigDecimal shippingFee;

    private BigDecimal orderAmount;

    /**
     * 优惠券id
     */
    private Long couponId;

    /**
     * 优惠券抵扣金额
     */
    private BigDecimal couponPaid;

    private BigDecimal moneyPaid;

    private BigDecimal payAmount;

    private Date createTime;

    private Date confirmTime;

    private Date payTime;

    private static final long serialVersionUID = 1L;

}