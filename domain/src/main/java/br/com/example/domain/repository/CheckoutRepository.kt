package br.com.example.domain.repository

import br.com.example.domain.entity.Checkout

interface CheckoutRepository {
    suspend fun save(checkout: Checkout): Checkout
    suspend fun update(checkout: Checkout): Checkout
    suspend fun delete(checkout: Checkout)
    suspend fun get(): Checkout
    suspend fun getHistory(user: String): List<Checkout>
    suspend fun addToHistory(checkout:Checkout)
}