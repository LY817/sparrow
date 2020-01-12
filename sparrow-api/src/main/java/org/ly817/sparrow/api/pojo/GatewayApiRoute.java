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

    /**
     * 数据库主键
     */
    private Long id;

    /**
     * 微服务名称中文描述
     */
    private String serviceName;

    /**
     * 微服务别名 微服务spring.application配置
     * 如sparrow-ms-user
     */
    private String serviceId;

    /**
     * 访问路径 The path (pattern) for the route
     * 配置文件中 zuul.routes.serviceId = path
     * 通过正则表达式匹配 如 /user/**
     * 其中user为ZuulProperties.ZuulRoute的id属性
     */
    private String path;

    /**
     * 服务的物理地址
     * 可以为空 通过serviceId与服务发现机制找到对应的物理地址
     * An alternative is to use a service ID and service discovery to find the physical address.
     */
    private String url;

    private Boolean retryable;

    /**
     * 数据查询标识 是否开启该微服务的网关映射
     */
    private Boolean enabled;

    private Integer stripPrefix;

    private String apiName;

    private Date stsTime;

    private static final long serialVersionUID = 1L;
}