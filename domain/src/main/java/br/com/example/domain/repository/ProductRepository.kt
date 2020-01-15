package br.com.example.domain.repository

import br.com.example.domain.entity.SupplierMenu

interface ProductRepository {
    fun getProductBySupplier(supplier: String): SupplierMenu
}