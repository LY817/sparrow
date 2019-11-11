package org.ly817.sparrow.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * coupon
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coupon implements Serializable {
    private Long couponId;

    private BigDecimal couponPrice;

    private Long userId;

    private Long orderId;

    private Integer couponSts;

    private Date usedTime;

    private static final long serialVersionUID = 1L;
}