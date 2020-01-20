package br.com.example.marmitapp.view.fragment.checkout

import android.app.AlertDialog
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
        btCheckoutAction.setOnClickListener {
            showConfirmation()
        }
    }

    private fun showConfirmation(){
        val builder = AlertDialog.Builder(this.context)
        builder.setTitle(getString(R.string.checkout_confirm_dialog_title))
        builder.setMessage(getString(R.string.checkout_confirm_dialog_message))
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton(getString(R.string.checkout_confirm_positive_action)){_, which ->
            finishCheckout()
        }
        builder.setNeutralButton(getString(R.string.checkout_confirm_neutral_action)){_, which ->}
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun finishCheckout(){
        viewModel.finishCheckout()
    }

    private fun toggleLoading(uiState: CheckoutUIState){
        loading.visibility = when(uiState){
            Loading -> View.VISIBLE
            else -> View.INVISIBLE
        }
    }

}
