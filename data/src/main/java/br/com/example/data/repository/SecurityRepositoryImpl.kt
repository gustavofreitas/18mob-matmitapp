package br.com.example.data.repository

import br.com.example.data.remote.datasource.SecurityDataSource
import br.com.example.data.remote.mapper.SecurityRemoteMapper.map
import br.com.example.domain.entity.SignUser
import br.com.example.domain.entity.User
import br.com.example.domain.repository.SecurityRepository
import java.lang.Exception

class SecurityRepositoryImpl(
    private val dataSource: SecurityDataSource
): SecurityRepository {
    override suspend fun signIn(user: SignUser): User {
        val signedUser =  dataSource.signIn(user.email, user.password)?.let{
             map(it)
        }

        if(signedUser != null)
            return signedUser
        else
            throw Exception()

    }

    override suspend fun signUp(user: SignUser): User {
        val signedUser =  dataSource.signUp(user.email, user.password)?.let{
            map(it)
        }

        if(signedUser != null)
            return signedUser
        else
            throw Exception()
    }

    override suspend fun hasLoggedUser(): Boolean {
        return dataSource.isUserLogged()
    }
}