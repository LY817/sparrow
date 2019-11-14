package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.pojo.Coupon;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LuoYu on 2019/10/30.
 */
@RequestMapping("/coupons")
public interface ICouponService {

    /**
     * 新增
     */
    @PostMapping
    Coupon addCoupon(Coupon coupon);

    /**
     * 修改
     */
    @PatchMapping
    Coupon updateCoupon(Coupon coupon);

    /**
     * 查询
     */
    @GetMapping("/{couponId}")
    Coupon getCouponById(@PathVariable("couponId") Long couponId);
}