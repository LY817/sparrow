package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.exception.APIException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LuoYu on 2019/8/14.
 */
@FeignClient(value = "sparrow-ms-credit")
public interface ICreditService {

    /**
     * 添加积分
     */
    @PostMapping("credit/add/{score}")
    void addCreditScore(@PathVariable("userId") Long userId,@PathVariable("score") int score);
}
