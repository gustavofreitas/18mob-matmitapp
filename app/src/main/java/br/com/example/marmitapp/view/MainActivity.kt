package br.com.example.marmitapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import br.com.example.marmitapp.R
import br.com.example.marmitapp.view.fragment.checkout.CheckoutFragmentDirections
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabCheckout.setOnClickListener { goToCheckout() }
    }

    private fun goToCheckout(){
        CheckoutFragmentDirections.actionGlobalCheckoutFragment().also{
            mainNavHostFragment.findNavController().navigate(it)
        }
    }
}
