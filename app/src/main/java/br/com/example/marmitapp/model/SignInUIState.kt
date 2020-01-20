package br.com.example.marmitapp.model

import androidx.lifecycle.MutableLiveData

sealed class SignInUIState {
    data class Error(val error: Throwable): SignInUIState()
    object Success: SignInUIState()
    object Loading: SignInUIState()
}

fun MutableLiveData<SignInUIState>.toSuccess(){
    value = SignInUIState.Success
}
fun MutableLiveData<SignInUIState>.toError(error: Throwable){
    value = SignInUIState.Error(error)
}
fun MutableLiveData<SignInUIState>.toLoading(){
    value = SignInUIState.Loading
}

