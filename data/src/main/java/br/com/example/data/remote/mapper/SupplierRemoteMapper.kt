package br.com.example.data.remote.mapper

import br.com.example.data.remote.model.SupplierRemote
import br.com.example.domain.entity.Supplier

object SupplierRemoteMapper {
    fun map(remoteData: SupplierRemote) = Supplier(
        id = remoteData.id,
        name = remoteData.name,
        photo = remoteData.photo
    )
}