package br.com.example.data.remote.datasource

import br.com.example.data.remote.model.SupplierWithProducts
import br.com.example.domain.entity.Product
import br.com.example.domain.entity.SupplierMenu

interface ProductDataSource {
    suspend fun getBySupplierId(id: String): SupplierMenu
}