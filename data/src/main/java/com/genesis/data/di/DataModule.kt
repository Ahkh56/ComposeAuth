package com.genesis.data.di

import com.genesis.data.remote.FirebaseAuthDataSource
import com.genesis.data.repository.AuthRepository
import com.genesis.data.repository.AuthRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single {
        FirebaseAuthDataSource(get())
    }
    single<AuthRepository> {
        AuthRepositoryImpl(get())
    }
}
