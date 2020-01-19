package br.com.example.marmitapp.view.fragment.productlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.example.domain.entity.SupplierMenu
import br.com.example.domain.usecases.GetProductListUseCase
import br.com.example.marmitapp.model.ProductListUIState
import br.com.example.marmitapp.model.toLoading
import br.com.example.marmitapp.model.toSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductListViewModel(
    val useCaseGetProductListUseCase: GetProductListUseCase
): ViewModel() {

    val _uiState = MutableLiveData<ProductListUIState>()
    val uiState: LiveData<ProductListUIState> = _uiState

    fun loadData(supplierId: String) {
        _uiState.toLoading()

        CoroutineScope(context = Dispatchers.IO).launch {
            val supplier = useCaseGetProductListUseCase.execute(supplierId)

            withContext(context = Dispatchers.Main){
                supplier?.let{
                    _uiState.toSuccess(it)
                }
            }
        }
    }

}