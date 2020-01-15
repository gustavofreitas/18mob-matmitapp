package br.com.example.domain.usecases

import br.com.example.domain.repository.CheckoutRepository

class GetCheckoutUseCase(
    private val checkoutRepository: CheckoutRepository
) {
    fun execute() = checkoutRepository.get()
}