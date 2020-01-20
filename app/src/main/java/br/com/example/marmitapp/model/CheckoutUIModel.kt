package br.com.example.marmitapp.model

import br.com.example.domain.entity.Product

data class CheckoutUIModel(
    val id: Int,
    val totalPrice: Double,
    val productList: List<Product>
)