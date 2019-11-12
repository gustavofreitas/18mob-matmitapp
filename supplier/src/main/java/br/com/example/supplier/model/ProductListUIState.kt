package br.com.example.supplier.model

import androidx.lifecycle.MutableLiveData

sealed class ProductListUIState {
    data class Error(val error: Throwable) : ProductListUIState()
    object Loading : ProductListUIState()
    object Success : ProductListUIState()
}

fun MutableLiveData<ProductListUIState>.toError(error: Throwable) {
    value = ProductListUIState.Error(error)
}

fun MutableLiveData<ProductListUIState>.toLoading() {
    value = ProductListUIState.Loading
}

fun MutableLiveData<ProductListUIState>.toSucess() {
    value = ProductListUIState.Success
}
