package br.com.example.data.local.model

import androidx.room.*
import br.com.example.data.local.converters.ProductItemConverter

@Entity
@TypeConverters(ProductItemConverter::class)
data class ProductCache(
    val description: String = "",
    val name: String = "",
    val price: Double = 0.0,
    val content: List<ProductItemCache> = listOf()
)