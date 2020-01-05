package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.exception.APIException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LuoYu on 2019/8/14.
 * ֧���ӿ�
 */
@FeignClient(value = "sparrow-ms-pay")
public interface IPayService {

    /**
     * ȷ���տ�
     *
     * @param payToken ����ƾ֤
     * @param amount ������
     *
     * @return ��ˮ��
     */
    @PostMapping("/pay/payCheck")
    String payCheck(@RequestBody String payToken,@RequestBody Double amount);


    /**
     * ������֧���ص�
     */
    @PostMapping("/pay/payCallback")
    String payCallback();

}
