package br.com.example.core.model

enum class FireBaseDocumentName(val documentName: String) {
    SUPPLIER("suppliers"),
    PRODUCT("products"),
    ADDRESS("address");

    companion object {
        fun getDocumentName(documentName: String) = valueOf(documentName.toLowerCase())
    }
}