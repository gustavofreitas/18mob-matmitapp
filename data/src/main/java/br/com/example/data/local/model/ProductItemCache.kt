package br.com.example.data.local.model

import androidx.room.Entity

@Entity
data class ProductItemCache (
    val name: String = "",
    val price: Double = 0.0,
    val default: Boolean = false
)