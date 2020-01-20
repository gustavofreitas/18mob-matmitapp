package br.com.example.marmitapp.di

import br.com.example.marmitapp.view.fragment.checkout.CheckoutViewModel
import br.com.example.marmitapp.view.fragment.productlist.ProductListViewModel
import br.com.example.marmitapp.view.fragment.supplierlist.SupplierViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel{
        SupplierViewModel(get())
    }

    viewModel{
        ProductListViewModel(get())
    }

    viewModel{
        CheckoutViewModel(get())
    }
}


