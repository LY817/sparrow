package org.ly817.sparrow.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * order_product_log
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductLog implements Serializable {
    private Long productId;

    private Long orderId;

    private Integer number;

    private Date logTime;

    private static final long serialVersionUID = 1L;

}