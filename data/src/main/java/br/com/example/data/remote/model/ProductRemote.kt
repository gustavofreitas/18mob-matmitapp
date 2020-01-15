package br.com.example.data.remote.model

import java.io.Serializable

data class ProductRemote (
    val description: String = "",
    val name: String = "",
    val price: Double = 0.0,
    val content: List<ProductItemRemote> = listOf()
): Serializable

data class ProductItemRemote(
    val name: String = "",
    val price: Double = 0.0,
    val default: Boolean = false
): Serializable