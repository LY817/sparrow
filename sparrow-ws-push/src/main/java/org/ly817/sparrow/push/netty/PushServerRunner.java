package org.ly817.sparrow.push.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @author LY
 * @date 2019/11/18 13:13
 * <p>
 * Description:
 */
@Component
@DependsOn("pushServer")
public class PushServerRunner implements ApplicationRunner {

    private final Logger logger = LoggerFactory.getLogger(PushServerRunner.class);

    @Autowired
    private PushServer pushServer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        pushServer.start();
    }
}
