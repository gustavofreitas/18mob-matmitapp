package br.com.example.data.local.model

import androidx.room.Embedded
import androidx.room.Entity

@Entity
data class ProductCache(
    val description: String = "",
    val name: String = "",
    val price: Double = 0.0,
    @Embedded
    val content: List<ProductItemCache> = listOf()
)