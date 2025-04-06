package _9dev.study.product.api.domain.service

import _9dev.study.product.api.domain.entity.Product
import _9dev.study.product.api.domain.repository.ProductRepository
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
) : ProductService {
    override fun findProductById(id: Long): Product? = productRepository.findById(id).getOrNull()
}
