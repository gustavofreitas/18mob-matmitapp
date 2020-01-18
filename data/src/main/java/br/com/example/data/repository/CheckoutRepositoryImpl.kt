package br.com.example.data.repository

import br.com.example.data.local.datasource.CheckoutDataSource
import br.com.example.domain.entity.Checkout
import br.com.example.domain.repository.CheckoutRepository

class CheckoutRepositoryImpl(
    private val checkoutDataSource: CheckoutDataSource
): CheckoutRepository {
    override suspend fun save(checkout: Checkout){checkoutDataSource.insert(checkout)}

    override suspend fun update(checkout: Checkout){checkoutDataSource.update(checkout)}

    override suspend fun delete(checkout: Checkout){
        checkoutDataSource.delete()
    }

    override suspend fun get() = checkoutDataSource.get()

    override suspend fun getHistory(user: String): List<Checkout> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun addToHistory(checkout: Checkout) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}