package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.exception.APIException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LuoYu on 2019/8/14.
 * 支付接口
 */
@RequestMapping("pay")
public interface IPayService {

    /**
     * 确认收款
     *
     * @param payToken 付款凭证
     * @param amount 付款金额
     *
     * @return 流水号
     */
    @PostMapping("payCheck")
    String payCheck(@RequestBody String payToken,@RequestBody Double amount) throws APIException;


    /**
     * 第三方支付回调
     */
    @PostMapping("payCallback")
    String payCallback() throws APIException;

}
