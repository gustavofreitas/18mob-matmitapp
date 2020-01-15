package br.com.example.data.remote.model

import com.google.firebase.firestore.DocumentId
import java.io.Serializable

class SupplierRemote (
    @DocumentId val id: String = "",
    val name: String = "",
    val photo: String = ""
): Serializable