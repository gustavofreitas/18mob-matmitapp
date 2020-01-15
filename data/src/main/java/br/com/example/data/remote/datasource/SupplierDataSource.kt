package br.com.example.data.remote.datasource

import br.com.example.domain.entity.Supplier

interface SupplierDataSource {
    suspend fun getAll(): List<Supplier>
}