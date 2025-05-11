package dev.study.coupon.api.controller

import dev.study.coupon.api.dto.CouponResponse
import dev.study.coupon.api.service.CouponService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CouponController(
    private val couponService: CouponService,
) {
    @PostMapping("/coupon/claim/{couponName}")
    fun claimCoupon(
        @PathVariable couponName: String,
    ): ResponseEntity<CouponResponse> {
        val response = couponService.issueCoupon(couponName)
        return if (response.couponCode == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(response)
        } else {
            ResponseEntity.ok(response)
        }
    }
}
