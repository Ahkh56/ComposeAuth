package com.genesis.feature_auth.data.repository

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class AuthRepository @Inject public constructor( // <-- Add 'public' here
    private val auth: FirebaseAuth?
) {

    // You also need to make the methods you want to override 'open'
    open fun login(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        auth?.signInWithEmailAndPassword(email, password)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onResult(true, null)
                } else {
                    onResult(false, task.exception?.message)
                }
            }
    }

    open fun register(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        auth?.createUserWithEmailAndPassword(email, password)
            ?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onResult(true, null)
                } else {
                    onResult(false, task.exception?.message)
                }
            }
    }

    open fun logout() {
        auth?.signOut()
    }
}
