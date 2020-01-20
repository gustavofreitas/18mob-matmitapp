package br.com.example.domain.entity

data class SignUser(
    val email: String,
    val password: String
)

data class User(
    val email: String
)