package br.com.example.domain.usecases

import br.com.example.domain.entity.Checkout
import br.com.example.domain.entity.Product
import br.com.example.domain.repository.CheckoutRepository

class AddProductToCheckoutUseCase(
    private val checkoutRepository: CheckoutRepository,
    private val calculate: CalculateProductUseCase
) {
    suspend fun execute(product: Product){
        val checkout = checkoutRepository.get()

        checkout.totalPrice += calculate.execute(product)

        when(checkout.id == 0) {
            true -> checkoutRepository.save(checkout)
            false -> checkoutRepository.update(checkout)
        }
    }
}