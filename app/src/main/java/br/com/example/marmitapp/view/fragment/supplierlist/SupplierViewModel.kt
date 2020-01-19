package br.com.example.marmitapp.view.fragment.supplierlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.example.domain.usecases.GetSupplierListUseCase
import br.com.example.marmitapp.model.SupplierListUIState
import br.com.example.marmitapp.model.SupplierUIModel
import br.com.example.marmitapp.model.toLoading
import br.com.example.marmitapp.model.toSuccess
import kotlinx.coroutines.*

class SupplierViewModel(
    private val useCase: GetSupplierListUseCase
): ViewModel() {
    private val _uiState = MutableLiveData<SupplierListUIState>()

    val uiState: LiveData<SupplierListUIState> = _uiState

    fun loadData(){

        //onLoadind
        _uiState.toLoading()

        CoroutineScope(context = Dispatchers.IO).launch {
            useCase.execute().map {supplier ->
                SupplierUIModel(
                    supplier.id,
                    supplier.name,
                    ""
                )

            }.also{
                withContext(context = Dispatchers.Main){
                        _uiState.toSuccess(it)
                }
            }
        }

        //onSuccess


        //onError
        //_uiState.toError({error})

    }
}