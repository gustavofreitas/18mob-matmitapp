package br.com.example.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import br.com.example.data.local.converters.ProductListConverter

@Entity(tableName = "checkout")
@TypeConverters(ProductListConverter::class)
class CheckoutCache (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val totalPrice: Double = 0.0,
    val productList: List<ProductCache> = listOf()
)