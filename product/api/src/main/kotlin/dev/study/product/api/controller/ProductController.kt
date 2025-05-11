package dev.study.product.api.web.controller

import dev.study.product.api.domain.entity.Product
import dev.study.product.api.domain.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    private val productService: ProductService,
) {
    @GetMapping("/product/{id}")
    fun getProduct(
        @PathVariable id: Long,
    ): Product? {
        return productService.findProductById(id)
    }
}
