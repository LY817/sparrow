package org.ly817.sparrow.order.config;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LY
 * @date 2019/11/10 20:50
 * <p>
 * Description:
 * 分布式锁配置
 */
@Configuration
public class RedissonLockConfig {

    @Value("${cmd.redis.ip}")
    private String redisHost;

    @Value("${cmd.redis.port}")
    private String redisPort;

    @Bean
    Redisson redisson() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + redisHost + ":" + redisPort);
        return (Redisson) Redisson.create(config);
    }
}
