package com.genesis.feature_auth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genesis.feature_auth.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class AuthViewModel @Inject constructor(
    // FIX 1: Changed 'private' to 'protected'
    // This allows subclasses like FakeAuthViewModel to access the repository.
    protected val repository: AuthRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow<Result<String>?>(null)
    val loginState: StateFlow<Result<String>?> = _loginState

    open fun login(email: String, password: String) {
        viewModelScope.launch {
            repository.login(email, password) { success, error ->
                _loginState.value = if (success) Result.success("Login successful")
                else Result.failure(Exception(error))
            }
        }
    }

    // FIX 2: Added 'open' to allow overriding in fakes/mocks if needed.
    open fun register(email: String, password: String) {
        viewModelScope.launch {
            repository.register(email, password) { success, error ->
                _loginState.value = if (success) Result.success("Registration successful")
                else Result.failure(Exception(error))
            }
        }
    }

    // FIX 3: Added 'open' to allow overriding in fakes/mocks if needed.
    open fun logout() {
        repository.logout()
    }
}
