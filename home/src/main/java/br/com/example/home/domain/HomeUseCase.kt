package br.com.example.home.domain

import br.com.example.core.data.SupplierRepository
import br.com.example.home.model.SupplierUIModel


class HomeUseCase {

    private val repository = SupplierRepository()

    suspend fun getAll(): List<SupplierUIModel?> = repository.getAll().map {
        it?.let{
            SupplierUIModel(
                it.id,
                it.name,
                ""
            )
        }
    }
}