package br.com.example.domain.repository

import br.com.example.domain.entity.SupplierMenu

interface ProductRepository {
    suspend fun getProductBySupplier(supplier: String): SupplierMenu
}