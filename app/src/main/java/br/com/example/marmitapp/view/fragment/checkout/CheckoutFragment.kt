package br.com.example.marmitapp.view.fragment.checkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import br.com.example.marmitapp.R
import br.com.example.marmitapp.model.CheckoutUIModel
import br.com.example.marmitapp.model.CheckoutUIState
import br.com.example.marmitapp.model.CheckoutUIState.Error
import br.com.example.marmitapp.model.CheckoutUIState.Success
import br.com.example.marmitapp.model.CheckoutUIState.Loading
import br.com.example.marmitapp.view.fragment.checkout.adapter.CheckoutListAdapter
import kotlinx.android.synthetic.main.fragment_checkout.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CheckoutFragment : Fragment() {

    private val viewModel: CheckoutViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadData()
    }

    private fun initView() {
        viewModel.uiState.observe(viewLifecycleOwner, Observer(::updateUI))
    }

    private fun updateUI(uiState: CheckoutUIState){
        when(uiState){
            is Error -> onError(uiState.error)
            is Success -> onSuccess(uiState.checkout)
        }
        toggleLoading(uiState)
    }

    private fun onError(error: Throwable){

    }

    private fun onSuccess(checkout: CheckoutUIModel){
        tvTotalCheckout.text = checkout.totalPrice.toString()
        rvCheckoutItems.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = CheckoutListAdapter(
                checkout
            )

        }
    }


    private fun toggleLoading(uiState: CheckoutUIState){
        loading.visibility = when(uiState){
            Loading -> View.VISIBLE
            else -> View.INVISIBLE
        }
    }

}
