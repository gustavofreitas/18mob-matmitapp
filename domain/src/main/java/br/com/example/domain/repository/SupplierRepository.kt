package br.com.example.domain.repository

import br.com.example.domain.entity.Supplier

interface SupplierRepository {
    suspend fun getAll(): List<Supplier>
}