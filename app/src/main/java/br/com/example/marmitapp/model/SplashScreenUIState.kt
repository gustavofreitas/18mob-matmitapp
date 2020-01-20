package br.com.example.marmitapp.model

import androidx.lifecycle.MutableLiveData

sealed class SplashScreenUIState {
    data class Error(val error: Throwable): SplashScreenUIState()
    data class Success(val logged: Boolean): SplashScreenUIState()
    object Loading: SplashScreenUIState()
}

fun MutableLiveData<SplashScreenUIState>.toSuccess(logged: Boolean){
    value = SplashScreenUIState.Success(logged)
}
fun MutableLiveData<SplashScreenUIState>.toError(error: Throwable){
    value = SplashScreenUIState.Error(error)
}
fun MutableLiveData<SplashScreenUIState>.toLoading(){
    value = SplashScreenUIState.Loading
}

