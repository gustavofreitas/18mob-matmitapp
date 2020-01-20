package br.com.example.marmitapp.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.example.domain.usecases.HasLoggedUserUserCase
import br.com.example.marmitapp.model.SplashScreenUIState
import br.com.example.marmitapp.model.toLoading
import br.com.example.marmitapp.model.toSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashScreenViewModel(
    private val useCase: HasLoggedUserUserCase
): ViewModel() {

    val _uiState = MutableLiveData<SplashScreenUIState>()
    val uiState: LiveData<SplashScreenUIState> = _uiState

    fun checkLoggedUser(){
        _uiState.toLoading()

        CoroutineScope(context = Dispatchers.IO).launch {
            useCase.execute().also{
                withContext(context = Dispatchers.Main){
                    _uiState.toSuccess(it)
                }
            }
        }
    }
}