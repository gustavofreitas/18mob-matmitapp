package br.com.example.data.local.datasource

import br.com.example.data.local.database.CheckoutDao
import br.com.example.data.local.mapper.CheckoutCacheMapper
import br.com.example.domain.entity.Checkout

class CheckoutDataSourceImpl(
    private val checkoutDao: CheckoutDao
): CheckoutDataSource {
    override fun get(): Checkout {
        return checkoutDao.get().let { CheckoutCacheMapper.map(it) }
    }

    override fun insert(checkout: Checkout) {
        checkoutDao.insert(CheckoutCacheMapper.map(checkout))
    }

    override fun update(checkout: Checkout) {
        checkoutDao.update(CheckoutCacheMapper.map(checkout))
    }

    override fun delete() {
        checkoutDao.delete()
    }
}