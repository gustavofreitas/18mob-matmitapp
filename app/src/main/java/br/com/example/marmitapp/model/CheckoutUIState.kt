package br.com.example.marmitapp.model

import androidx.lifecycle.MutableLiveData

sealed class CheckoutUIState {
    data class Error(val error: Throwable): CheckoutUIState()
    data class Success(val insertClassHere: String): CheckoutUIState()
    object Loading: CheckoutUIState()
}

fun MutableLiveData<CheckoutUIState>.toSuccess(insertClassHere: String){
    value = CheckoutUIState.Success(insertClassHere)
}
fun MutableLiveData<CheckoutUIState>.toError(error: Throwable){
    value = CheckoutUIState.Error(error)
}
fun MutableLiveData<CheckoutUIState>.toLoading(){
    value = CheckoutUIState.Loading
}

