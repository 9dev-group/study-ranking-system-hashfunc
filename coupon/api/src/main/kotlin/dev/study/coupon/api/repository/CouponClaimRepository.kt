package dev.study.coupon.api.repository

import dev.study.coupon.api.domain.CouponClaim
import org.springframework.data.jpa.repository.JpaRepository

interface CouponClaimRepository : JpaRepository<CouponClaim, Long> {
    fun findByName(name: String): CouponClaim?
}
