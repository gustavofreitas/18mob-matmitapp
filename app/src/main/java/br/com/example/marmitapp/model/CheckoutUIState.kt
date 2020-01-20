package br.com.example.marmitapp.model

import androidx.lifecycle.MutableLiveData

sealed class CheckoutUIState {
    data class Error(val error: Throwable): CheckoutUIState()
    data class Success(val checkout: CheckoutUIModel): CheckoutUIState()
    object Loading: CheckoutUIState()
}

fun MutableLiveData<CheckoutUIState>.toSuccess(checkout: CheckoutUIModel){
    value = CheckoutUIState.Success(checkout)
}
fun MutableLiveData<CheckoutUIState>.toError(error: Throwable){
    value = CheckoutUIState.Error(error)
}
fun MutableLiveData<CheckoutUIState>.toLoading(){
    value = CheckoutUIState.Loading
}

