package dev.study.coupon.api.service

import dev.study.coupon.api.domain.Coupon
import dev.study.coupon.api.dto.CouponResponse
import dev.study.coupon.api.repository.CouponClaimRepository
import dev.study.coupon.api.repository.CouponRepository
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class CouponService(
    private val couponRepository: CouponRepository,
    private val couponClaimRepository: CouponClaimRepository,
    private val redisTemplate: RedisTemplate<String, String>,
) {
    companion object {
        private val DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd")
    }

    @Transactional
    fun issueCoupon(couponName: String): CouponResponse {
        val couponClaim =
            couponClaimRepository.findByName(couponName)
                ?: return CouponResponse()

        val redisCountKey = "coupon:${couponClaim.name.lowercase()}:count"
        val currentCount = redisTemplate.opsForValue().increment(redisCountKey) ?: 1L

        if (currentCount > couponClaim.maxCouponCount) {
            redisTemplate.opsForValue().decrement(redisCountKey)
            return CouponResponse()
        }

        val couponCode = generateCouponCode(couponClaim.name, currentCount)

        val coupon =
            Coupon(
                couponCode = couponCode,
            )
        couponRepository.save(coupon)

        return CouponResponse(
            couponCode = couponCode,
        )
    }

    private fun generateCouponCode(
        couponName: String,
        sequence: Long,
    ): String {
        val date = LocalDateTime.now().format(DATE_FORMATTER)
        return "$couponName-$date-${String.format("%04d", sequence)}"
    }
}
