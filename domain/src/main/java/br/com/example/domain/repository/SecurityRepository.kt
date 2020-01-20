package br.com.example.domain.repository

import br.com.example.domain.entity.SignUser
import br.com.example.domain.entity.User

interface SecurityRepository {
    suspend fun signIn(user: SignUser): User

    suspend fun signUp(user: SignUser): User

    suspend fun hasLoggedUser(): Boolean
}