package org.ly817.sparrow.push.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.ly817.sparrow.api.dto.push.PushEvent;
import org.springframework.stereotype.Service;



/**
 * Created by LuoYu on 2019/11/26.
 */
@Service
@RocketMQMessageListener(topic = "push",consumerGroup = "push_consumer")
public class PushMQEventDispatcher implements RocketMQListener<PushEvent> {
    @Override
    public void onMessage(PushEvent event) {

    }
}
