package org.ly817.sparrow.api.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * order
 * @author 
 */
public class Order implements Serializable {
    private Long orderId;

    private String paySerialId;

    private Long userId;

    private Integer number;

    private Double amount;

    /**
     * 0 未确定 1 已确定 2已取消 3无效 4退款
     */
    private Integer orderSts;

    /**
     * 0 未支付 1 支付中 2 已支付
     */
    private Integer paySts;

    /**
     *  0 未发货 1 已发货 2 已退货
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPaySerialId() {
        return paySerialId;
    }

    public void setPaySerialId(String paySerialId) {
        this.paySerialId = paySerialId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Integer getOrderSts() {
        return orderSts;
    }

    public void setOrderSts(Integer orderSts) {
        this.orderSts = orderSts;
    }

    public Integer getPaySts() {
        return paySts;
    }

    public void setPaySts(Integer paySts) {
        this.paySts = paySts;
    }

    public Integer getShippingSts() {
        return shippingSts;
    }

    public void setShippingSts(Integer shippingSts) {
        this.shippingSts = shippingSts;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getCouponPaid() {
        return couponPaid;
    }

    public void setCouponPaid(BigDecimal couponPaid) {
        this.couponPaid = couponPaid;
    }

    public BigDecimal getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(BigDecimal moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Order other = (Order) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getPaySerialId() == null ? other.getPaySerialId() == null : this.getPaySerialId().equals(other.getPaySerialId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getNumber() == null ? other.getNumber() == null : this.getNumber().equals(other.getNumber()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getOrderSts() == null ? other.getOrderSts() == null : this.getOrderSts().equals(other.getOrderSts()))
            && (this.getPaySts() == null ? other.getPaySts() == null : this.getPaySts().equals(other.getPaySts()))
            && (this.getShippingSts() == null ? other.getShippingSts() == null : this.getShippingSts().equals(other.getShippingSts()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getConsignee() == null ? other.getConsignee() == null : this.getConsignee().equals(other.getConsignee()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductNumber() == null ? other.getProductNumber() == null : this.getProductNumber().equals(other.getProductNumber()))
            && (this.getProductPrice() == null ? other.getProductPrice() == null : this.getProductPrice().equals(other.getProductPrice()))
            && (this.getProductAmount() == null ? other.getProductAmount() == null : this.getProductAmount().equals(other.getProductAmount()))
            && (this.getShippingFee() == null ? other.getShippingFee() == null : this.getShippingFee().equals(other.getShippingFee()))
            && (this.getOrderAmount() == null ? other.getOrderAmount() == null : this.getOrderAmount().equals(other.getOrderAmount()))
            && (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()))
            && (this.getCouponPaid() == null ? other.getCouponPaid() == null : this.getCouponPaid().equals(other.getCouponPaid()))
            && (this.getMoneyPaid() == null ? other.getMoneyPaid() == null : this.getMoneyPaid().equals(other.getMoneyPaid()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getConfirmTime() == null ? other.getConfirmTime() == null : this.getConfirmTime().equals(other.getConfirmTime()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getPaySerialId() == null) ? 0 : getPaySerialId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getNumber() == null) ? 0 : getNumber().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getOrderSts() == null) ? 0 : getOrderSts().hashCode());
        result = prime * result + ((getPaySts() == null) ? 0 : getPaySts().hashCode());
        result = prime * result + ((getShippingSts() == null) ? 0 : getShippingSts().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getConsignee() == null) ? 0 : getConsignee().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductNumber() == null) ? 0 : getProductNumber().hashCode());
        result = prime * result + ((getProductPrice() == null) ? 0 : getProductPrice().hashCode());
        result = prime * result + ((getProductAmount() == null) ? 0 : getProductAmount().hashCode());
        result = prime * result + ((getShippingFee() == null) ? 0 : getShippingFee().hashCode());
        result = prime * result + ((getOrderAmount() == null) ? 0 : getOrderAmount().hashCode());
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        result = prime * result + ((getCouponPaid() == null) ? 0 : getCouponPaid().hashCode());
        result = prime * result + ((getMoneyPaid() == null) ? 0 : getMoneyPaid().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getConfirmTime() == null) ? 0 : getConfirmTime().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", paySerialId=").append(paySerialId);
        sb.append(", userId=").append(userId);
        sb.append(", number=").append(number);
        sb.append(", amount=").append(amount);
        sb.append(", orderSts=").append(orderSts);
        sb.append(", paySts=").append(paySts);
        sb.append(", shippingSts=").append(shippingSts);
        sb.append(", address=").append(address);
        sb.append(", consignee=").append(consignee);
        sb.append(", productId=").append(productId);
        sb.append(", productNumber=").append(productNumber);
        sb.append(", productPrice=").append(productPrice);
        sb.append(", productAmount=").append(productAmount);
        sb.append(", shippingFee=").append(shippingFee);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", couponId=").append(couponId);
        sb.append(", couponPaid=").append(couponPaid);
        sb.append(", moneyPaid=").append(moneyPaid);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", createTime=").append(createTime);
        sb.append(", confirmTime=").append(confirmTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}