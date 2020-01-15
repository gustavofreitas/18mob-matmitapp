package br.com.example.domain.entity

import java.io.Serializable

data class Product(
    val description: String = "",
    val name: String = "",
    val price: Double = 0.0,
    val content: List<ProductItem> = listOf()
): Serializable