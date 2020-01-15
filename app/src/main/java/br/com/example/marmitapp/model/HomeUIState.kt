package br.com.example.marmitapp.model

import androidx.lifecycle.MutableLiveData

sealed class HomeUIState {
    data class Error(val error: Throwable): HomeUIState()
    data class Success(val suppliers: List<SupplierUIModel?>): HomeUIState()
    object Loading: HomeUIState()
}

fun MutableLiveData<HomeUIState>.toSuccess(suppliers: List<SupplierUIModel?>){
    value = HomeUIState.Success(suppliers)
}
fun MutableLiveData<HomeUIState>.toError(error: Throwable){
    value = HomeUIState.Error(error)
}
fun MutableLiveData<HomeUIState>.toLoading(){
    value = HomeUIState.Loading
}

