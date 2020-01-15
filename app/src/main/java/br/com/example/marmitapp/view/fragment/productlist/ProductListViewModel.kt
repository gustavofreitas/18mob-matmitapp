package br.com.example.marmitapp.view.fragment.productlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.example.supplier.domain.ProductListUseCase
import br.com.example.marmitapp.model.ProductListUIState
import br.com.example.marmitapp.model.toLoading
import br.com.example.marmitapp.model.toSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductListViewModel(): ViewModel() {
    val useCase = ProductListUseCase()

    val _uiState = MutableLiveData<br.com.example.marmitapp.model.ProductListUIState>()
    val uiState: LiveData<br.com.example.marmitapp.model.ProductListUIState> = _uiState

    fun loadData(supplierId: String) {
        _uiState.toLoading()

        CoroutineScope(context = Dispatchers.IO).launch {
            val supplier = useCase.getSupplierMenu(supplierId)

            withContext(context = Dispatchers.Main){
                supplier?.let{
                    _uiState.toSuccess(it)
                }
            }
        }
    }

}