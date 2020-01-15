package br.com.example.marmitapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.example.marmitapp.R
import com.google.firebase.analytics.FirebaseAnalytics

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        goToNext()
    }

    private fun goToNext(){

        Intent(this,  MainActivity::class.java).also{
            startActivity(it)
            this.finish()
        }
    }
}
