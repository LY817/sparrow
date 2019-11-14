package org.ly817.sparrow.push.socketio;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.springframework.context.annotation.Bean;


/**
 * Created by LuoYu on 2019/11/14.
 */
@org.springframework.context.annotation.Configuration
public class SocketIOConfig {

    @Bean
    public SocketIOServer socketIOServer(){
        Configuration socketConfig = new Configuration();
        socketConfig.setHostname("127.0.0.1");
        socketConfig.setPort(6666);
        socketConfig.setUpgradeTimeout(10000);
        // 消息超时阈值
        socketConfig.setPingTimeout(60000);
        // 消息心跳间隔
        socketConfig.setPingInterval(25000);


        // 握手协议参数使用JWT的Token认证方案
        socketConfig.setAuthorizationListener(data -> {
            // 可以使用如下代码获取用户密码信息
            String token = data.getSingleUrlParam("token");
            return true;
        });

        return new SocketIOServer(socketConfig);
    }

    @Bean
    public SpringAnnotationScanner springAnnotationScanner(SocketIOServer socketServer) {
        return new SpringAnnotationScanner(socketServer);
    }
}
