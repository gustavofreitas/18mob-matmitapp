package br.com.example.data.remote.datasource

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await

class SecurityDataSourceImpl(
    private val auth: FirebaseAuth
): SecurityDataSource {
    override suspend fun signIn(email: String, password: String): FirebaseUser? {
        auth.signInWithEmailAndPassword(email, password).await()

        return auth.currentUser ?: throw FirebaseAuthException("", "")
    }

    override suspend fun signUp(email: String, password: String): FirebaseUser? {
        auth.createUserWithEmailAndPassword(email, password).await()

        return auth.currentUser ?: throw FirebaseAuthException("", "") }

    override suspend fun isUserLogged() = auth.currentUser != null
}