package br.com.example.marmitapp.view.security.signin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import br.com.example.marmitapp.R
import br.com.example.marmitapp.model.SignInUIState
import br.com.example.marmitapp.view.MainActivity
import br.com.example.marmitapp.view.security.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInActivity : AppCompatActivity() {

    private val viewModel: SignInViewModel by viewModel()

    private val newUserRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    private fun initView(){
        viewModel.uiState.observe(this, Observer(::updateUI))

        btLogin.setOnClickListener {
            viewModel.sigIn(
                inputLoginEmail.text.toString(),
                inputLoginPassword.text.toString()
            )
        }
        btSignup.setOnClickListener {
            startActivityForResult(
                Intent(this, SignUpActivity::class.java),
                newUserRequestCode)
        }
    }

    private fun updateUI(uiState: SignInUIState?) {
        uiState?.let{
            when(it){
                is SignInUIState.Error -> TODO()
                SignInUIState.Success -> goToHome()
                SignInUIState.Loading -> return
            }
        }
    }

    private fun goToHome() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finishAffinity()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == newUserRequestCode && resultCode == Activity.RESULT_OK) {
            goToHome()
        }
    }
}