package br.com.example.domain.usecases

import br.com.example.domain.entity.Product

class CalculateProductUseCase {
    fun execute(product: Product): Double{
        return product.price + product.content.sumByDouble { item -> item.price }
    }
}