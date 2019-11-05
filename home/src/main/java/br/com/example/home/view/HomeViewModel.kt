package br.com.example.home.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.example.home.model.HomeUIState
import br.com.example.home.model.toError
import br.com.example.home.model.toLoading
import br.com.example.home.model.toSuccess

class HomeViewModel: ViewModel() {
    init{
        loadData()
    }

    private val _uiState by lazy {
        MutableLiveData<HomeUIState>()
    }
    val uiState: LiveData<HomeUIState> = _uiState

    private fun loadData(){

        //onLoadind
        //_uiState.toLoading()

        //onSuccess
        //_uiState.toSuccess({suppliers})

        //onError
        //_uiState.toError({error})

    }
}