package br.com.example.supplier.domain

import br.com.example.core.data.SupplierRepository

class ProductListUseCase {

    private val repository = SupplierRepository()

    suspend fun getSupplierMenu(supplierId: String) = repository
        .getProductsBySupplierId(supplierId)

}