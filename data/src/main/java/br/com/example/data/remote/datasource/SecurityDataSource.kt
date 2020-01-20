package br.com.example.data.remote.datasource

import com.google.firebase.auth.FirebaseUser

interface SecurityDataSource {
    suspend fun signIn(
        email: String,
        password: String
    ): FirebaseUser?

    suspend fun signUp(
        email: String,
        password: String
    ): FirebaseUser?

    suspend fun isUserLogged(): Boolean
}