package _9dev.study.coupon.api.controller

import _9dev.study.coupon.api.dto.CouponResponse
import _9dev.study.coupon.api.service.CouponService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CouponController(
    private val couponService: CouponService
) {

    @PostMapping("/coupon/claim")
    fun claimCoupon(): ResponseEntity<CouponResponse> {
        val response = couponService.issueCoupon()
        return ResponseEntity.ok(response)
    }
} 