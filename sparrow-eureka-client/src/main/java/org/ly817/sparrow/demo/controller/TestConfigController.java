package org.ly817.sparrow.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LuoYu
 * @date 2019/06/03 16:33
 * <p>
 * Description:
 */
@RestController
public class TestConfigController {

    @Value("${luoyu.phone}")
    private String phone;

    @GetMapping("/config/test")
    public String test(){
        return this.phone;
    }
}
