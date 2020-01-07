package br.com.example.supplier.view.fragment.productlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.example.supplier.domain.ProductListUseCase
import br.com.example.supplier.model.ProductListUIState
import br.com.example.supplier.model.toLoading
import br.com.example.supplier.model.toSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductListViewModel(): ViewModel() {
    val useCase = ProductListUseCase()

    val _uiState = MutableLiveData<ProductListUIState>()
    val uiState: LiveData<ProductListUIState> = _uiState

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