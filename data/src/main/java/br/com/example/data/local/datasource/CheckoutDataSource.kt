package br.com.example.data.local.datasource

import br.com.example.domain.entity.Checkout

interface CheckoutDataSource {
    fun get(): Checkout
    fun insert(checkout: Checkout)
    fun update(checkout: Checkout)
    fun delete()

}