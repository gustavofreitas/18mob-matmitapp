package br.com.example.domain.entity

data class SupplierMenu (
    val id: String = "",
    val name: String = "",
    val photo: String = "",
    val menu: List<Product> = listOf()
)


