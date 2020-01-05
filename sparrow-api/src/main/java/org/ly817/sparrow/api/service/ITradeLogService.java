package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.pojo.OrderProductLog;
import org.ly817.sparrow.api.pojo.OrderUserBalanceLog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LY
 * @date 2019/11/10 18:59
 * <p>
 * Description:
 * 交易日志记录服务
 */
@FeignClient(value = "sparrow-ms-trade-log")
public interface ITradeLogService {

    @PostMapping("/trade/log/order-product")
    int addOrderProductLog(@RequestBody OrderProductLog orderProductLog);

    @PostMapping("/trade/log/order-user-balance")
    int addOrderUserBalanceLog(@RequestBody OrderUserBalanceLog orderUserBalanceLog);


}
