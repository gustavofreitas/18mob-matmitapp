package br.com.example.core.model

import com.google.firebase.firestore.DocumentId
import java.io.Serializable


data class Supplier (
    @DocumentId val id: String = "",
    val name: String = "",
    val photo: String = ""
): Serializable