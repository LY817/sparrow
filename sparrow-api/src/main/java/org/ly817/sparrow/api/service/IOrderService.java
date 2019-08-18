package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.exception.APIException;
import org.ly817.sparrow.api.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LuoYu on 2019/8/14.
 */
@RequestMapping("order")
public interface IOrderService {

    /**
     * 创建订单
     * v1:最简化版本：order -> inventory -> credit 调用链路
     * - 核查 + 预减库存
     * @see IInventoryService#checkInventory(Long, Integer)
     * - 计算金额
     *
     * - 生成订单号
     *
     * - 调用付款接口
     * @see IPayService
     * - 调用成功
     *   - 确认减库存
     *   - 加积分
     *   - 通知发货
     * - 调用失败 返回订单号和失败原因
     *
     * v2:
     * @param order
     */
    @PostMapping("add")
    void addOrder(Order order) throws APIException;
}
