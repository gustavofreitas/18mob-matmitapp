package br.com.example.core.data

import android.util.Log
import br.com.example.core.model.Supplier
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

const val COLLECTION_NAME = "suppliers"

class SupplierRepository {

    private val fireStore = FirebaseFirestore.getInstance()

    suspend fun getAll() = fireStore
        .collection(COLLECTION_NAME)
        .get()
        .await()
        .documents
        .map{
            it.toObject(Supplier::class.java)
        }

}