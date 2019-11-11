package org.ly817.sparrow.coupon;

import org.ly817.sparrow.api.pojo.Coupon;
import org.ly817.sparrow.api.service.ICouponService;
import org.ly817.sparrow.common.SnowflakeIdWorker;
import org.ly817.sparrow.coupon.dao.CouponDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LY
 * @date 2019/10/30 21:05
 * <p>
 * Description:
 */
@RestController
public class CouponServiceImpl implements ICouponService {

    @Autowired
    public CouponDao couponDao;

    @Autowired
    public SnowflakeIdWorker idWorker;

    @Override
    public Coupon addCoupon(@RequestBody Coupon coupon) {
        coupon.setCouponId(idWorker.nextId());
        couponDao.insert(coupon);
        return coupon;
    }

    @Override
    public Coupon updateCoupon(@RequestBody Coupon coupon) {
        couponDao.updateByPrimaryKey(coupon);
        return coupon;
    }

    @Override
    public Coupon getCouponById(@PathVariable("couponId") Long couponId) {
        return couponDao.selectByPrimaryKey(couponId);
    }
}
