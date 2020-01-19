package br.com.example.marmitapp.model

import androidx.lifecycle.MutableLiveData

sealed class SupplierListUIState {
    data class Error(val error: Throwable): SupplierListUIState()
    data class Success(val suppliers: List<SupplierUIModel?>): SupplierListUIState()
    object Loading: SupplierListUIState()
}

fun MutableLiveData<SupplierListUIState>.toSuccess(suppliers: List<SupplierUIModel?>){
    value = SupplierListUIState.Success(suppliers)
}
fun MutableLiveData<SupplierListUIState>.toError(error: Throwable){
    value = SupplierListUIState.Error(error)
}
fun MutableLiveData<SupplierListUIState>.toLoading(){
    value = SupplierListUIState.Loading
}

