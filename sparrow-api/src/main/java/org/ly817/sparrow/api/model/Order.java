package org.ly817.sparrow.api.model;

import org.ly817.sparrow.api.enums.OrderSts;

import java.io.Serializable;

/**
 * @author LY
 * @date 2019/08/14 14:51
 * <p>
 * Description:
 * 订单DTO
 */
public class Order  implements Serializable {

    private String orderId;

    private OrderSts orderSts;

    /**
     * 交易流水号
     */
    private String paySerialId;

    private Long userId;

    private Long productId;

    /**
     * 产品数量
     */
    private Integer number;

    /**
     * 总金额
     */
    private Double amount;

    public String getPaySerialId() {
        return paySerialId;
    }

    public void setPaySerialId(String paySerialId) {
        this.paySerialId = paySerialId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
