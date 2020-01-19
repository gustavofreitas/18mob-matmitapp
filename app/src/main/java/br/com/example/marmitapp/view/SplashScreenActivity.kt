package br.com.example.marmitapp.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.example.marmitapp.R
import br.com.example.marmitapp.view.login.LoginActivity
import com.google.firebase.analytics.FirebaseAnalytics
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val TEMPO_AGUARDO_SPLASHSCREEN = 3500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        val preferences = getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
        val isFirstOpen = preferences.getBoolean("open_first", true)

        if (isFirstOpen) {
            markAppAlreadyOpen(preferences)
            showSplash()
        } else {
            goToNext()
        }

    }

    private fun markAppAlreadyOpen(preferences: SharedPreferences) {
        val editor = preferences.edit()
        editor.putBoolean("open_first", false)
        editor.apply()
    }

    /*private fun showLogin() {
        val nextScreen = Intent(this@SplashScreenActivity, LoginActivity::class.java)
        startActivity(nextScreen)
        finish()
    }*/

    private fun showSplash() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.animacao_splash)
        anim.reset()
        ivLogo.clearAnimation()
        ivLogo.startAnimation(anim)

        Handler().postDelayed({
            goToNext()
        }, TEMPO_AGUARDO_SPLASHSCREEN)
    }


    private fun goToNext(){

        Intent(this,  LoginActivity::class.java).also{
            startActivity(it)
            this.finish()
        }
    }
}
