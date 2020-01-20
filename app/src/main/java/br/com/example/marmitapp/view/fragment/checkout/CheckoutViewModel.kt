package br.com.example.marmitapp.view.fragment.checkout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.example.domain.entity.Checkout
import br.com.example.domain.usecases.BuyUseCase
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
    private val checkoutUseCase: GetCheckoutUseCase,
    private val buyUseCase: BuyUseCase
) : ViewModel() {

    val _uiState = MutableLiveData<CheckoutUIState>()
    val uiState: LiveData<CheckoutUIState> = _uiState
    var currentCheckout = Checkout()

    fun loadData(){

        _uiState.toLoading()

        CoroutineScope(context = Dispatchers.IO).launch {
            checkoutUseCase.execute().apply {
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
                    currentCheckout = it
                }
            }
        }
    }

    fun finishCheckout(){
        _uiState.toLoading()
        CoroutineScope(context = Dispatchers.IO).launch {
            buyUseCase.execute(currentCheckout)
            .also {
                withContext(context = Dispatchers.Main){
                    _uiState.toSuccess(CheckoutUIModel(
                        currentCheckout.id,
                        currentCheckout.totalPrice,
                        currentCheckout.productList
                    ))
                }
            }
        }
    }

}
