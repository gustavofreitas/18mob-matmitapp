package br.com.example.domain.usecases

import br.com.example.domain.entity.SignUser
import br.com.example.domain.entity.User
import br.com.example.domain.repository.SecurityRepository

class SignUpUseUseCase(
    private val repository: SecurityRepository
) {

    suspend fun execute(user: SignUser): User {
        return repository.signUp(user)
    }

}