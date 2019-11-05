package br.com.example.home.model

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import br.com.example.core.model.Supplier

sealed class HomeUIState {
    data class Error(val error: Throwable): HomeUIState()
    data class Success(val suppliers: PagedList<Supplier>): HomeUIState()
    object Loading: HomeUIState()
}

fun MutableLiveData<HomeUIState>.toSuccess(suppliers: PagedList<Supplier>){
    value = HomeUIState.Success(suppliers)
}
fun MutableLiveData<HomeUIState>.toError(error: Throwable){
    value = HomeUIState.Error(error)
}
fun MutableLiveData<HomeUIState>.toLoading(){
    value = HomeUIState.Loading
}