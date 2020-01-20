package br.com.example.marmitapp.view.security.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.example.domain.entity.SignUser
import br.com.example.domain.usecases.SignUpUseUseCase
import br.com.example.marmitapp.model.SignUpUIState
import br.com.example.marmitapp.model.toLoading
import br.com.example.marmitapp.model.toSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SignUpViewModel(
    private val useCase: SignUpUseUseCase
): ViewModel() {

    val _uiState = MutableLiveData<SignUpUIState>()
    val uiState: LiveData<SignUpUIState> = _uiState

    fun sigUp(email: String, password: String){
        _uiState.toLoading()

        val signUser = SignUser(email, password)

        CoroutineScope(context = Dispatchers.IO).launch {
            useCase.execute(signUser)

            withContext(context = Dispatchers.Main){
                _uiState.toSuccess()
            }
        }
    }
}