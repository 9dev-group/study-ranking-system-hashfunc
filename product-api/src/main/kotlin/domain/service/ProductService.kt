package _9dev.study.product.api.domain.service

import _9dev.study.product.api.domain.entity.Product

interface ProductService {
    fun findProductById(id: Long): Product?
}
