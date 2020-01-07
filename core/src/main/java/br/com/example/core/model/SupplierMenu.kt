package br.com.example.core.model

import com.google.firebase.firestore.DocumentId
import java.io.Serializable

data class SupplierMenu (
    @DocumentId
    val id: String = "",
    val name: String = "",
    val photo: String = "",
    val menu: List<Product> = listOf()
): Serializable


