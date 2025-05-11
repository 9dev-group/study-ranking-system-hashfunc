package dev.study.coupon.api.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class CouponClaim(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id")
    val coupon: Coupon,
    @Column(name = "name")
    val name: String,
    @Column(name = "max_coupon_count")
    val maxCouponCount: Long,
    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now(),
)
