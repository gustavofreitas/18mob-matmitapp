package br.com.example.domain.entity

import java.io.Serializable

data class ProductItem(
    val name: String = "",
    val price: Double = 0.0,
    val default: Boolean = false
): Serializable