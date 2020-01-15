package br.com.example.domain.entity

class Checkout(
    val id: Int = 0,
    var totalPrice: Double = 0.0,
    val productList: MutableList<Product> = mutableListOf()
)