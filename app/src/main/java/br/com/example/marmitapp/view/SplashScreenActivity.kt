package br.com.example.marmitapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.example.marmitapp.R
import br.com.example.marmitapp.view.security.signin.SignInActivity
import com.google.firebase.analytics.FirebaseAnalytics
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import br.com.example.marmitapp.model.SplashScreenUIState
import kotlinx.android.synthetic.main.activity_splash_screen.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashScreenActivity : AppCompatActivity() {

    private val viewModel: SplashScreenViewModel by viewModel()

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        showSplash()

        viewModel.uiState.observe(this, Observer(::updateUI))

        viewModel.checkLoggedUser()
    }

    private fun updateUI(uiState: SplashScreenUIState?){
        uiState?.let{
            when(it){
                is SplashScreenUIState.Error -> TODO()
                is SplashScreenUIState.Success -> onSucess(it.logged)
                SplashScreenUIState.Loading -> return
            }
        }
    }

    private fun onSucess(logged: Boolean){
        if(logged)
            goToNext(Intent(this, MainActivity::class.java))
        else
            goToNext(Intent(this,SignInActivity::class.java))
    }

    private fun showSplash() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.animacao_splash)
        anim.reset()
        ivLogo.clearAnimation()
        ivLogo.startAnimation(anim)
    }


    private fun goToNext(intent: Intent){
        intent.also{
            startActivity(it)
            this.finish()
        }
    }
}
