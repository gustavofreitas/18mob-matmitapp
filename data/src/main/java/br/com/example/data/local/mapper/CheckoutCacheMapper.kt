package br.com.example.data.local.mapper

import br.com.example.data.local.model.CheckoutCache
import br.com.example.domain.entity.Checkout

object CheckoutCacheMapper {
    fun map(cacheData: CheckoutCache) = Checkout(
        id = cacheData.id,
        totalPrice = cacheData.totalPrice,
        productList = cacheData.productList.toMutableList()
    )

    fun map(data: Checkout) = CheckoutCache(
        id = data.id,
        totalPrice = data.totalPrice,
        productList = data.productList
    )
}