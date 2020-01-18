package br.com.example.domain.usecases

import br.com.example.domain.entity.Supplier
import br.com.example.domain.repository.SupplierRepository

class GetSupplierListUseCase(
    private val supplierRepository: SupplierRepository
) {

    suspend fun execute()
    : List<Supplier> {
        return supplierRepository.getAll()

    }

}