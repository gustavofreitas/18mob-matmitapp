package br.com.example.domain.usecases

import br.com.example.domain.entity.Checkout
import br.com.example.domain.repository.CheckoutRepository

class BuyUseCase (
    private val checkoutRepository: CheckoutRepository
){
    suspend fun execute(checkout: Checkout) {
        checkoutRepository.save(checkout)
    }
}