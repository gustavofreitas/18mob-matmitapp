package br.com.example.marmitapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.example.marmitapp.model.SupplierUIModel
import br.com.example.marmitapp.R
import br.com.example.marmitapp.model.HomeUIState
import br.com.example.marmitapp.model.HomeUIState.Error
import br.com.example.marmitapp.model.HomeUIState.Success
import br.com.example.marmitapp.model.HomeUIState.Loading
import br.com.example.marmitapp.view.adapter.SupplierListAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by lazy{
        ViewModelProviders.of(this)[HomeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initView()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadData()
    }

    private fun initView() {
        viewModel.uiState.observe(this, Observer(::updateUI))
    }

    private fun updateUI(uiState: HomeUIState){
        when(uiState){
            is Error -> onError(uiState.error)
            is Success -> onSuccess(uiState.suppliers)
        }
        toggleLoading(uiState)
    }

    private fun onError(error: Throwable){

    }

    private fun onSuccess(suppliers: List<SupplierUIModel?>){
        rvSuppliers.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = SupplierListAdapter(
                suppliers
            )

        }
    }

    private fun toggleLoading(uiState: HomeUIState){
        loading.visibility = when(uiState){
            Loading -> View.VISIBLE
            else -> View.INVISIBLE
        }
    }

}