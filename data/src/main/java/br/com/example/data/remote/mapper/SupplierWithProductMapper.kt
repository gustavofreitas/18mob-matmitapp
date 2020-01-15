package br.com.example.data.remote.mapper

import br.com.example.data.remote.model.ProductItemRemote
import br.com.example.data.remote.model.ProductRemote
import br.com.example.data.remote.model.SupplierWithProducts
import br.com.example.domain.entity.Product
import br.com.example.domain.entity.ProductItem
import br.com.example.domain.entity.SupplierMenu

object SupplierWithProductMapper {
    fun map(remoteData: SupplierWithProducts) = SupplierMenu(
        id = remoteData.id,
        name = remoteData.name,
        photo = remoteData.photo,
        menu = remoteData.productList.map{map(it)}
    )

    fun map(remoteData: ProductItemRemote) = ProductItem(
        name = remoteData.name,
        default = remoteData.default,
        price = remoteData.price
    )

    fun map(remoteData: ProductRemote) = Product(
        description = remoteData.description,
        name = remoteData.name,
        price = remoteData.price,
        content = remoteData.content.map{map(it)}
    )
}