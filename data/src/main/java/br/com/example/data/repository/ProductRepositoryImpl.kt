package br.com.example.data.repository

import br.com.example.data.remote.datasource.ProductDataSource
import br.com.example.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val productDataSource: ProductDataSource
): ProductRepository {
    override suspend fun getProductBySupplier(supplier: String) =
        productDataSource.getBySupplierId(supplier)

}