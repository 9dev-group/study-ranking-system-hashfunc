package dev.study.coupon.api.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class CouponClaim(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "name")
    val name: String,
    @Column(name = "max_coupon_count")
    val maxCouponCount: Long,
    @Column(name = "created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime = LocalDateTime.now(),
)
