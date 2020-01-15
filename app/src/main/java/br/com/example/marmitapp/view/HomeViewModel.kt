package br.com.example.marmitapp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.example.home.domain.HomeUseCase
import br.com.example.marmitapp.model.HomeUIState
import br.com.example.marmitapp.model.toLoading
import br.com.example.marmitapp.model.toSuccess
import kotlinx.coroutines.*

class HomeViewModel: ViewModel() {
    private val _uiState = MutableLiveData<HomeUIState>()

    val uiState: LiveData<HomeUIState> = _uiState

    fun loadData(){

        //onLoadind
        _uiState.toLoading()

        CoroutineScope(context = Dispatchers.IO).launch {

            val suppliers = HomeUseCase().getAll()

            withContext(context = Dispatchers.Main){
                suppliers.let{
                    _uiState.toSuccess(it)
                }

            }

        }

        //onSuccess


        //onError
        //_uiState.toError({error})

    }
}