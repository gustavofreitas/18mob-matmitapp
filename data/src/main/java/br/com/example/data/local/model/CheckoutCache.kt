package br.com.example.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "checkout")
class CheckoutCache (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val totalPrice: Double = 0.0/*,
    @Embedded
    val productList: List<ProductCache> = listOf()*/
)