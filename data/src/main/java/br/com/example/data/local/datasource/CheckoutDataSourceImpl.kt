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

    override fun insert(checkout: Checkout): Checkout {
       return checkoutDao.insert(CheckoutCacheMapper.map(checkout)).let{CheckoutCacheMapper.map(it)}
    }

    override fun update(checkout: Checkout): Checkout {
        return checkoutDao.update(CheckoutCacheMapper.map(checkout)).let{CheckoutCacheMapper.map(it)}
    }

    override fun delete() {
        checkoutDao.delete()
    }
}