package _9dev.study.coupon.api.repository

import _9dev.study.coupon.api.domain.Coupon
import org.springframework.data.jpa.repository.JpaRepository

interface CouponRepository : JpaRepository<Coupon, Long>
