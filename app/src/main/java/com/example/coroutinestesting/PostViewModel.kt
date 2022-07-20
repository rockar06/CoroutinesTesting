package com.example.coroutinestesting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout

class PostViewModel : ViewModel() {

    private val innerMessage = MutableStateFlow("")
    val message: StateFlow<String> get() = innerMessage

    fun loadMessage() {
        viewModelScope.launch {
            innerMessage.value = "Hello testers!"
        }
    }
}