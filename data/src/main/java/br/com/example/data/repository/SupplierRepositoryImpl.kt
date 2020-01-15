package br.com.example.data.repository

import br.com.example.data.remote.datasource.SupplierDataSource
import br.com.example.domain.repository.SupplierRepository

class SupplierRepositoryImpl(
    private val supplierDataSource: SupplierDataSource
) : SupplierRepository {
    override suspend fun getAll() = supplierDataSource.getAll()
}