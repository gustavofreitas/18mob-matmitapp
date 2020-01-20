package br.com.example.marmitapp.view.security.signup

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.example.marmitapp.R
import br.com.example.marmitapp.model.SignUpUIState

import kotlinx.android.synthetic.main.activity_signup.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity : AppCompatActivity() {

    private val viewModel: SignUpViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        initView()
    }

    private fun initView(){
        viewModel.uiState.observe(this, Observer(::updateUI))

        btCreate.setOnClickListener {
            viewModel.sigUp(
                inputEmail.text.toString(),
                inputPassword.text.toString()
            )
        }
    }

    private fun updateUI(uiState: SignUpUIState?) {
        uiState?.let{
            when(it){
                is SignUpUIState.Error -> TODO()
                SignUpUIState.Success -> onSucess()
                SignUpUIState.Loading -> return
            }
        }
    }

    private fun onSucess(){
        val returnIntent = Intent()
        setResult(RESULT_OK, returnIntent)
        finish()
    }

}
