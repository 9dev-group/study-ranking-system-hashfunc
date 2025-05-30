package dev.study.product.api.domain.repository

import dev.study.product.api.domain.entity.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<Product, Long>
