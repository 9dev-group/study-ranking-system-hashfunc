package dev.study.coupon.api.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
class Coupon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "coupon_code")
    val couponCode: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_claim_id")
    val couponClaim: CouponClaim? = null,
    @Column(name = "issued_at")
    val issuedAt: LocalDateTime = LocalDateTime.now(),
)
