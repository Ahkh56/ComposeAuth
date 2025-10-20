package com.genesis.core.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    /**
     * This is the single source of truth for the FirebaseAuth instance
     * for the entire application.
     */
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    // DO NOT provide FirebaseAuthDataSource or AuthRepository here.
    // Those belong to the feature that uses them.
}
