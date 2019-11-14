package org.ly817.sparrow.push.socketio;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/**
 * Created by LuoYu on 2019/11/14.
 *
 * SocketIOServer启动
 */
@Component
public class SocketIOServerRunner implements ApplicationRunner {

    @Autowired
    private SocketIOServer socketIOServer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        socketIOServer.start();
    }
}
