package br.com.example.marmitapp.view.fragment.checkout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.example.marmitapp.model.CheckoutUIState

class CheckoutViewModel : ViewModel() {

    val _uiState = MutableLiveData<CheckoutUIState>()
    val uiState: LiveData<CheckoutUIState> = _uiState

    fun loadData(){

    }
}
