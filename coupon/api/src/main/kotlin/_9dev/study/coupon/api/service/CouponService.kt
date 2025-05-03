package _9dev.study.coupon.api.service

import _9dev.study.coupon.api.domain.Coupon
import _9dev.study.coupon.api.dto.CouponResponse
import _9dev.study.coupon.api.repository.CouponRepository
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class CouponService(
    private val couponRepository: CouponRepository,
    private val redisTemplate: RedisTemplate<String, String>
) {
    companion object {
        private const val MAX_COUPON_COUNT = 5L
        private val DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd")
        private const val COUPON_COUNT_KEY = "coupon:count"
    }

    @Transactional
    fun issueCoupon(): CouponResponse {
        val currentCount = redisTemplate.opsForValue().increment(COUPON_COUNT_KEY) ?: 1L

        if (currentCount > MAX_COUPON_COUNT) {
            redisTemplate.opsForValue().decrement(COUPON_COUNT_KEY)
            return CouponResponse()
        }

        val couponCode = generateCouponCode(currentCount)

        val coupon = Coupon(
            couponCode = couponCode
        )
        couponRepository.save(coupon)

        return CouponResponse(
            couponCode = couponCode
        )
    }

    private fun generateCouponCode(sequence: Long): String {
        val date = LocalDateTime.now().format(DATE_FORMATTER)
        return "COUPON-$date-${String.format("%04d", sequence)}"
    }
}
