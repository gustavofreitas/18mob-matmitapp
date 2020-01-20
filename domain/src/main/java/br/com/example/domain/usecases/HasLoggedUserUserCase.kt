package br.com.example.domain.usecases

import br.com.example.domain.repository.SecurityRepository

class HasLoggedUserUserCase(
    private val repository: SecurityRepository
) {
    suspend fun execute() = repository.hasLoggedUser()
}