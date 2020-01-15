package br.com.example.domain.repository

import br.com.example.domain.entity.Checkout

interface CheckoutRepository {
    fun save(checkout: Checkout): Checkout
    fun update(checkout: Checkout): Checkout
    fun delete(checkout: Checkout)
    fun get(): Checkout
    fun getHistory(user: String): List<Checkout>
    fun addToHistory(checkout:Checkout)
}