package org.ly817.sparrow.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * product
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private Long productId;

    private String productName;

    private BigDecimal price;

    private Integer inventory;

    private String desc;

    private Date addTime;

    private static final long serialVersionUID = 1L;

}