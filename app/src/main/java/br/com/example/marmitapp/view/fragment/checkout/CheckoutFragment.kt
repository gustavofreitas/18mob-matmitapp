package br.com.example.marmitapp.view.fragment.checkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.example.marmitapp.R
import br.com.example.marmitapp.model.CheckoutUIState
import org.koin.androidx.viewmodel.ext.android.viewModel

class CheckoutFragment : Fragment() {

    private val viewModel: CheckoutViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadData()
    }

    private fun updateUI(uiState: CheckoutUIState?){
        uiState?.apply {
            when(this){
                is CheckoutUIState.Error -> TODO()
                is CheckoutUIState.Success -> TODO()
                CheckoutUIState.Loading -> TODO()
            }
        }
    }

}
