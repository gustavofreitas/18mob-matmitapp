package br.com.example.marmitapp.view.security.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.example.domain.entity.SignUser
import br.com.example.domain.usecases.SignInUserUseCase
import br.com.example.marmitapp.model.SignInUIState
import br.com.example.marmitapp.model.toLoading
import br.com.example.marmitapp.model.toSuccess
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInViewModel(
    private val useCase: SignInUserUseCase
): ViewModel() {

    val _uiState = MutableLiveData<SignInUIState>()
    val uiState: LiveData<SignInUIState> = _uiState

    fun sigIn(email: String, password: String){
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