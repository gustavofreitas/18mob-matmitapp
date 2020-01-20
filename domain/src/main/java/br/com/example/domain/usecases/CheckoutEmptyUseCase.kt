package br.com.example.domain.usecases

import br.com.example.domain.repository.CheckoutRepository

class CheckoutEmptyUseCase(
    private val checkoutRepository: CheckoutRepository
) {
    suspend fun execute(): Boolean {
        val checkout = checkoutRepository.get()
        return checkout.productList.size == 0
    }
}