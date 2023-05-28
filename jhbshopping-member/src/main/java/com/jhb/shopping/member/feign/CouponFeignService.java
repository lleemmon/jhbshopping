package com.jhb.shopping.member.feign;

import com.jhb.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("jhbshopping-coupon")
public interface CouponFeignService {
    @RequestMapping("/coupon/smscoupon/member/list")
    R memberCoupons();
}
