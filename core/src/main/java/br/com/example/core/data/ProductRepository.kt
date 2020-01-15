package br.com.example.core.data

import br.com.example.core.model.FireBaseDocumentName
import br.com.example.core.model.SupplierMenu
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class ProductRepository {

    private val fireStore = FirebaseFirestore.getInstance()

    fun getProductById(productId: String){



    }

    suspend fun getProductsBySupplierId(id: String) = fireStore
        .collection(FireBaseDocumentName.SUPPLIER.documentName)
        .document(id)
        .get()
        .await()
        .toObject(SupplierMenu::class.java)

}