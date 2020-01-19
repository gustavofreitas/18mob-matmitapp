package br.com.example.marmitapp.view

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.example.marmitapp.R
import br.com.example.marmitapp.view.security.signin.SignInActivity
import com.google.firebase.analytics.FirebaseAnalytics
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import br.com.example.marmitapp.model.SplashScreenUIState
import androidx.appcompat.app.AlertDialog
import br.com.example.marmitapp.BuildConfig
import br.com.example.marmitapp.utils.RemoteConfig
import kotlinx.android.synthetic.main.activity_splash_screen.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashScreenActivity : AppCompatActivity() {

    private val viewModel: SplashScreenViewModel by viewModel()

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        showSplash()

        viewModel.uiState.observe(this, Observer(::updateUI))

        RemoteConfig.remoteConfigFetch()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    RemoteConfig.getFirebaseRemoteConfig().activateFetched()
                    val minVersionApp = RemoteConfig.getFirebaseRemoteConfig()
                        .getLong("min_version_app")
                        .toInt()
                    if (minVersionApp <= BuildConfig.VERSION_CODE)
                        viewModel.checkLoggedUser()
                    else
                        showAlertMinVersion()
                } else
                    viewModel.checkLoggedUser()
            }
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

    private fun showAlertMinVersion() {
        AlertDialog.Builder(this)
            .setTitle("Ops")
            .setMessage("Você esta utilizando uma versão muito antiga do aplicativo. Deseja atualizar?")
            .setPositiveButton("Sim") { dialog, which ->
                var intent: Intent
                try {
                    intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName"))
                    startActivity(intent)
                } catch (e: android.content.ActivityNotFoundException) {
                    intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    )
                    startActivity(intent)
                }
            }
            .setNegativeButton("Não") { dialog, which ->
                finish()
            }
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }
}
