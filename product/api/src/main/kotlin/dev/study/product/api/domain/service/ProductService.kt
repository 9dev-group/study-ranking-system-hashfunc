package dev.study.product.api.domain.service

import dev.study.product.api.domain.entity.Product

interface ProductService {
    fun findProductById(id: Long): Product?
}
