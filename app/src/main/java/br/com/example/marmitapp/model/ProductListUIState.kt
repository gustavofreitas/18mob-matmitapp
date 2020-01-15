package br.com.example.marmitapp.model

import androidx.lifecycle.MutableLiveData
import br.com.example.domain.entity.SupplierMenu

sealed class ProductListUIState {
    data class Error(val error: Throwable) : ProductListUIState()
    object Loading : ProductListUIState()
    data class Success(val supplier: SupplierMenu) : ProductListUIState()
}

fun MutableLiveData<ProductListUIState>.toError(error: Throwable) {
    value = ProductListUIState.Error(error)
}

fun MutableLiveData<ProductListUIState>.toLoading() {
    value = ProductListUIState.Loading
}

fun MutableLiveData<ProductListUIState>.toSuccess(supplier: SupplierMenu) {
    value = ProductListUIState.Success(supplier)
}
