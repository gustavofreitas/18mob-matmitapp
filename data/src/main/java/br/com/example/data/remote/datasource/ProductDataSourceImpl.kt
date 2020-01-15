package br.com.example.data.remote.datasource

import br.com.example.data.remote.mapper.SupplierWithProductMapper
import br.com.example.data.remote.model.SupplierWithProducts
import br.com.example.domain.entity.SupplierMenu
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.tasks.await

class ProductDataSourceImpl(
    val fireStore: FirebaseFirestore
): ProductDataSource {
    override suspend fun getBySupplierId(id: String): SupplierMenu
        = fireStore
            .collection("suppliers")
            .document(id)
            .get()
            .await()
            .toObject(SupplierWithProducts::class.java).let {
            if(it == null)
                throw CancellationException()
            else
                return SupplierWithProductMapper.map(it)
        }
}