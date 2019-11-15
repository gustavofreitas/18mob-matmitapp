package br.com.example.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.example.core.extension.gone
import br.com.example.core.extension.visible
import br.com.example.home.model.SupplierUIModel
import br.com.example.home.R
import br.com.example.home.model.HomeUIState
import br.com.example.home.model.HomeUIState.Error
import br.com.example.home.model.HomeUIState.Success
import br.com.example.home.model.HomeUIState.Loading
import br.com.example.home.view.adapter.SupplierListAdapter
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
            adapter = SupplierListAdapter(suppliers)

        }
    }

    private fun toggleLoading(uiState: HomeUIState){
        when(uiState){
            Loading -> loading.visible()
            else -> loading.gone()
        }
    }

}
