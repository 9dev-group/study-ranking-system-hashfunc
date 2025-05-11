package dev.study.coupon.api.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Coupon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "coupon_code")
    val couponCode: String,
    @Column(name = "issued_at")
    val issuedAt: LocalDateTime = LocalDateTime.now(),
)
