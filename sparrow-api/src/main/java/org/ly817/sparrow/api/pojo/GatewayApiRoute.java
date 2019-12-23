package org.ly817.sparrow.api.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * gateway_api_route
 * @author 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GatewayApiRoute implements Serializable {
    private Long id;

    /**
     * 微服务名称
     */
    private String serviceName;

    /**
     * 微服务别名
     * 如sparrow-ms-user
     */
    private Long serviceId;

    private String path;

    private String url;

    private Boolean retryable;

    private Boolean enabled;

    private Integer stripPrefix;

    private String apiName;

    private Date stsTime;

    private static final long serialVersionUID = 1L;
}