package org.ly817.sparrow.push.socketio;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by LuoYu on 2019/11/14.
 */
@Component
public class SocketEventHandler {

    private final Logger logger = LoggerFactory.getLogger(SocketEventHandler.class);

    @Autowired
    private SocketIOServer server;

    @OnConnect
    public void onConnect(SocketIOClient client){

    }

    @OnDisconnect
    public void onDisConnect(SocketIOClient client){

    }

    @OnEvent("notification")
    public void notification(SocketIOClient client, AckRequest ackRequest) {

    }


}
