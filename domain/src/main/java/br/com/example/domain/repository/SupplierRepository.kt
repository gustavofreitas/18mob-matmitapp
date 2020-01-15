package br.com.example.domain.repository

import br.com.example.domain.entity.Supplier

interface SupplierRepository {
    fun getAll(): List<Supplier>
}