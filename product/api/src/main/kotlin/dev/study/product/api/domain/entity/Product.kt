package dev.study.product.api.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "product")
class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id") val id: Long = 0,
    @Column(name = "region") val region: String,
    @Column(name = "name") val name: String,
    @Column(name = "category") val category: String,
    @Column(name = "price") val price: Int,
    @Column(name = "seller") val seller: String,
    @Column(name = "origin") val origin: String,
    @Column(name = "url") val url: String,
    @Column(name = "created_at") val createdAt: LocalDateTime,
    @Column(name = "updated_at") val updatedAt: LocalDateTime,
)
