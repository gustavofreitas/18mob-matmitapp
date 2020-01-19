package br.com.example.marmitapp.view.fragment.supplierlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.example.marmitapp.model.SupplierUIModel
import br.com.example.marmitapp.R
import br.com.example.marmitapp.model.SupplierListUIState
import br.com.example.marmitapp.model.SupplierListUIState.Error
import br.com.example.marmitapp.model.SupplierListUIState.Success
import br.com.example.marmitapp.model.SupplierListUIState.Loading
import br.com.example.marmitapp.view.fragment.supplierlist.adapter.SupplierListAdapter
import kotlinx.android.synthetic.main.fragment_supplier.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SupplierFragment : Fragment() {

    private val supplierViewModel: SupplierViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_supplier, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onResume() {
        super.onResume()
        supplierViewModel.loadData()
    }

    private fun initView() {
        supplierViewModel.uiState.observe(viewLifecycleOwner, Observer(::updateUI))
    }

    private fun updateUI(uiState: SupplierListUIState){
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
            layoutManager = LinearLayoutManager(activity)
            adapter = SupplierListAdapter(
                suppliers,
                ::goToNext
            )

        }
    }

    private fun toggleLoading(uiState: SupplierListUIState){
        loading.visibility = when(uiState){
            Loading -> View.VISIBLE
            else -> View.INVISIBLE
        }
    }

    private fun goToNext(supplierId: String){
        SupplierFragmentDirections.actionSupplierFragmentToProductListFragment(supplierId).also{
            this.findNavController().navigate(it)
        }
    }

}
