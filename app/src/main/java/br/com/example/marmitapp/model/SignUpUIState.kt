package br.com.example.marmitapp.model

import androidx.lifecycle.MutableLiveData

sealed class SignUpUIState {
    data class Error(val error: Throwable): SignUpUIState()
    object Success: SignUpUIState()
    object Loading: SignUpUIState()
}

fun MutableLiveData<SignUpUIState>.toSuccess(){
    value = SignUpUIState.Success
}
fun MutableLiveData<SignUpUIState>.toError(error: Throwable){
    value = SignUpUIState.Error(error)
}
fun MutableLiveData<SignUpUIState>.toLoading(){
    value = SignUpUIState.Loading
}

