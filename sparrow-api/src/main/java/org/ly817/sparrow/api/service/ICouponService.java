package org.ly817.sparrow.api.service;

import org.ly817.sparrow.api.pojo.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by LuoYu on 2019/10/30.
 */
@FeignClient(value = "sparrow-ms-coupon")
public interface ICouponService {

    /**
     * ����
     */
    @PostMapping("/coupons")
    Coupon addCoupon(Coupon coupon);

    /**
     * �޸�
     */
    @PatchMapping("/coupons")
    Coupon updateCoupon(Coupon coupon);

    /**
     * ��ѯ
     */
    @GetMapping("/coupons/{couponId}")
    Coupon getCouponById(@PathVariable("couponId") Long couponId);
}
