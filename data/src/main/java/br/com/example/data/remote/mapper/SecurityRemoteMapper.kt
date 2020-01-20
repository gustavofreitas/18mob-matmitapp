package br.com.example.data.remote.mapper

import br.com.example.domain.entity.User
import com.google.firebase.auth.FirebaseUser

object SecurityRemoteMapper {

    fun map(remoteData: FirebaseUser) =
        User(remoteData.email!!)
}