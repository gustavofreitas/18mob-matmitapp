package br.com.example.core.data

import br.com.example.core.model.Supplier
import br.com.example.core.model.SupplierMenu
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

    suspend fun getProductsBySupplierId(id: String) = fireStore
        .collection(COLLECTION_NAME)
        .document(id)
        .get()
        .await()
        .toObject(SupplierMenu::class.java)
}