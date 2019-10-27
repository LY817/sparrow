package org.ly817.sparrow.global.idworker;

import org.ly817.sparrow.common.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LY
 * @date 2019/10/26 15:20
 * <p>
 * Description:
 * 雪花算法主键生成器
 */
@Configuration
public class SnowflakeIDConfiguration {

    @Bean
    public SnowflakeIdWorker idWorker(){
        return new SnowflakeIdWorker(1L,1L);
    }
}
