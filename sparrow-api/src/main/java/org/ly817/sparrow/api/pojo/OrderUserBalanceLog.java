package org.ly817.sparrow.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * order_user_balance_log
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderUserBalanceLog implements Serializable {
    private Long userId;

    private Long orderId;

    /**
     * 1 订单付款 2 订单退款
     */
    private Integer operateType;

    private BigDecimal amount;

    private Date logTime;

    private static final long serialVersionUID = 1L;

}