package br.com.example.domain.di

import br.com.example.domain.usecases.AddProductToCheckoutUseCase
import br.com.example.domain.usecases.GetProductListUseCase
import br.com.example.domain.usecases.GetSupplierListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetProductListUseCase(
            get()
        )
        AddProductToCheckoutUseCase(
            get(),
            get()
        )
        GetSupplierListUseCase(
            get()
        )
    }
}

val domainModule = listOf(useCaseModule)