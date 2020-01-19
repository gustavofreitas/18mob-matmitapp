package br.com.example.marmitapp.view.fragment.productlist


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.example.domain.entity.Product
import br.com.example.domain.entity.SupplierMenu
import br.com.example.marmitapp.R

import br.com.example.marmitapp.model.ProductListUIState
import br.com.example.marmitapp.view.fragment.productlist.adapter.ProductListAdapter
import kotlinx.android.synthetic.main.fragment_product_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductListFragment : Fragment() {
    private val viewModel: ProductListViewModel by viewModel()

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
    }



    private fun initView() {
        ibExit.setOnClickListener {
            findNavController().navigateUp()
        }
        viewModel.uiState.observe(viewLifecycleOwner, Observer(::updateUI))

        arguments?.get("supplierId").toString().let{
            viewModel.loadData(it)
        }
    }

    private fun onSuccess(supplier: SupplierMenu) {
        val fragment = this
        rvSuppliers.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(fragment.activity)
            adapter =
                ProductListAdapter(
                    supplier.menu,
                    ::goToNext
                )

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
        loading.visibility = when(uiState){
            ProductListUIState.Loading -> View.VISIBLE
            else -> View.INVISIBLE
        }
    }

    private fun goToNext(product: Product){
        ProductListFragmentDirections.actionProductListFragmentToSelectedProductFragment(product).also {
            findNavController().navigate(it)
        }
    }
}
