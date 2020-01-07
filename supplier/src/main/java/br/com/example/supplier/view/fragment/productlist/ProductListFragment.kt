package br.com.example.supplier.view.fragment.productlist


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.example.core.extension.gone
import br.com.example.core.extension.visible
import br.com.example.core.model.SupplierMenu
import br.com.example.core.navigation.SupplierNavigation

import br.com.example.supplier.R
import br.com.example.supplier.model.ProductListUIState
import br.com.example.supplier.view.fragment.productlist.adapter.ProductListAdapter
import kotlinx.android.synthetic.main.fragment_product_list.*

/**
 * A simple [Fragment] subclass.
 */
class ProductListFragment : Fragment() {
    private val viewModel: ProductListViewModel by lazy{
        ViewModelProviders.of(this)[ProductListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        test()
    }

    private fun test() {

    }

    private fun initView() {
        ibExit.setOnClickListener {
            activity?.finish()
        }
        viewModel.uiState.observe(viewLifecycleOwner, Observer(::updateUI))
        activity?.intent?.getStringExtra(SupplierNavigation.SUPPLIER_ID)?.let{
            viewModel.loadData(it)
        }

    }

    private fun onSuccess(supplier: SupplierMenu) {
        val fragment = this
        rvSuppliers.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(fragment.activity)
            adapter = ProductListAdapter(supplier.menu, fragment)

        }
    }

    private fun updateUI(uiState: ProductListUIState?) {
        uiState?.apply {
            when(this){
                is ProductListUIState.Error -> TODO()
                is ProductListUIState.Success -> onSuccess(supplier)
            }
            toggleLoading(this)
        }
    }

    private fun toggleLoading(uiState: ProductListUIState){
        when(uiState){
            ProductListUIState.Loading -> loading.visible()
            else -> loading.gone()
        }
    }
}
