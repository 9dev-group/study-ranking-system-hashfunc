package dev.study.coupon.api.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
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
