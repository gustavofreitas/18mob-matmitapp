package br.com.example.marmitapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.example.marmitapp.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        goToNext()
    }

    private fun goToNext(){
        Intent("action.home.open").also{
            startActivity(it)
        }
        finish()
    }
}
