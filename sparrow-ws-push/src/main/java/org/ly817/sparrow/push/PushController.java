package org.ly817.sparrow.push;

import org.ly817.sparrow.push.netty.PushClientCenter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LuoYu on 2019/11/18.
 */
@RestController
@RequestMapping("/push")
public class PushController {
    @GetMapping("/user/{userId}/{msg}")
    public void pushToUserId(@PathVariable("userId") String userId,
                             @PathVariable("msg") String msg){
        PushClientCenter.sendMsgByUserId(userId,msg);
    }
}
