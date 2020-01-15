package br.com.example.core.data

import br.com.example.core.model.Supplier
import br.com.example.core.model.SupplierMenu
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import br.com.example.core.model.FireBaseDocumentName.SUPPLIER

class SupplierRepository {

    private val fireStore = FirebaseFirestore.getInstance()

    suspend fun getAll() = fireStore
        .collection(SUPPLIER.documentName)
        .get()
        .await()
        .documents
        .map{
            it.toObject(Supplier::class.java)
        }

    suspend fun getProductsBySupplierId(id: String) = fireStore
        .collection(SUPPLIER.documentName)
        .document(id)
        .get()
        .await()
        .toObject(SupplierMenu::class.java)
}