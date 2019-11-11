package org.ly817.sparrow.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * user
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Long userId;

    private String userName;

    private String password;

    private Integer score;

    private String phone;

    private Date regTime;

    private BigDecimal balance;

    private static final long serialVersionUID = 1L;

}