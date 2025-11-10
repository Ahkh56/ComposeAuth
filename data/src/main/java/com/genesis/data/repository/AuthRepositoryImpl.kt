package com.genesis.data.repository

import com.genesis.data.remote.FirebaseAuthDataSource
import com.genesis.domain.model.User

class AuthRepositoryImpl(
    private val firebaseAuthDataSource: FirebaseAuthDataSource
): AuthRepository {

    override suspend fun login(email: String, password: String): Result<User> {
        return firebaseAuthDataSource.login(email, password).map { firebaseUser ->
            User(id = firebaseUser.uid, email = firebaseUser.email ?: "")
        }
    }

    override suspend fun register(email: String, password: String): Result<User> {
        return firebaseAuthDataSource.register(email, password).map { firebaseUser ->
            User(id = firebaseUser.uid, email = firebaseUser.email ?: "")
        }
    }

    override fun logout() = firebaseAuthDataSource.logout()

    override fun getCurrentUser(): User? {
        val firebaseUser = firebaseAuthDataSource.getCurrentUser() ?: return null
        return User(id = firebaseUser.uid, email = firebaseUser.email ?: "")
    }
}
