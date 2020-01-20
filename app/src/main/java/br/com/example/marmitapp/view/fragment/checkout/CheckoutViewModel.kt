package br.com.example.marmitapp.view.fragment.checkout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.example.domain.usecases.GetCheckoutUseCase
import br.com.example.marmitapp.model.CheckoutUIModel
import br.com.example.marmitapp.model.CheckoutUIState
import br.com.example.marmitapp.model.toLoading
import br.com.example.marmitapp.model.toSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CheckoutViewModel(
    private val useCase: GetCheckoutUseCase
) : ViewModel() {

    val _uiState = MutableLiveData<CheckoutUIState>()
    val uiState: LiveData<CheckoutUIState> = _uiState

    fun loadData(){

        _uiState.toLoading()

        CoroutineScope(context = Dispatchers.IO).launch {
            useCase.execute().apply {
                CheckoutUIModel(
                    this.id,
                    this.totalPrice,
                    this.productList
                )
            }.also{
                withContext(context = Dispatchers.Main){
                    _uiState.toSuccess(CheckoutUIModel(
                        it.id,
                        it.totalPrice,
                        it.productList
                    ))
                }
            }
        }


    }
}
