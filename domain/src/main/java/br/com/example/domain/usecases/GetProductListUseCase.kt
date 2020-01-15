package br.com.example.domain.usecases

import br.com.example.domain.entity.Product
import br.com.example.domain.entity.SupplierMenu
import br.com.example.domain.repository.ProductRepository

class GetProductListUseCase(
    private val productRepository: ProductRepository
) {

    suspend fun execute(supplier: String): SupplierMenu{
        return productRepository.getProductBySupplier(supplier)
    }

}