package br.com.example.data.remote.datasource

import br.com.example.data.remote.mapper.SupplierRemoteMapper
import br.com.example.data.remote.model.SupplierRemote
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.tasks.await

class SupplierDataSourceImpl(private val firestore: FirebaseFirestore): SupplierDataSource {

    override suspend fun getAll() = firestore
        .collection("suppliers")
        .get()
        .await()
        .documents
        .map{
            it.toObject(SupplierRemote::class.java).let{
                if(it == null)
                    throw CancellationException()
                else
                    SupplierRemoteMapper.map(it)
            }
        }
}