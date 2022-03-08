package com.epicdevler.stockin.presentation.auth.utils.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val _contentState = Channel<AuthContentState>()
    val contentState = _contentState.receiveAsFlow()

    fun setUiContent(state: AuthContentState){
        viewModelScope.launch {
            _contentState.send(state)
        }
    }
}