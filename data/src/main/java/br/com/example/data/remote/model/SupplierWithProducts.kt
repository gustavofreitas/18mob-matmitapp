package br.com.example.data.remote.model

import com.google.firebase.firestore.DocumentId
import java.io.Serializable

data class SupplierWithProducts(
    @DocumentId
    val id: String = "",
    val name: String = "",
    val photo: String = "",
    val productList: List<ProductRemote> = listOf()
): Serializable