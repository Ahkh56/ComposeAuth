package com.genesis.feature_auth.di

// 1. REMOVE FirebaseAuth related imports as they are no longer needed here.
// import com.google.firebase.auth.FirebaseAuth
import dagger.Module
// import dagger.Provides // No longer needed if there are no other providers
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
// import javax.inject.Singleton // No longer needed if there are no other providers

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    // 2. DELETE the provideFirebaseAuth() function entirely.
    // Hilt will now find the provider for FirebaseAuth in your `:core` module,
    // which resolves the conflict.

    // You can add other providers that are SPECIFIC to the auth feature here later.
    // For example, providing your AuthRepository.
}
