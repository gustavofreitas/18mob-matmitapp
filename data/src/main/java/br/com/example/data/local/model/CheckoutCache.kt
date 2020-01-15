package br.com.example.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.example.domain.entity.Product

@Entity(tableName = "checkout")
class CheckoutCache (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val totalPrice: Double = 0.0,
    val productList: List<Product> = listOf()
)