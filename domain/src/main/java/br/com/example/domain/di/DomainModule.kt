package br.com.example.domain.di

import br.com.example.domain.usecases.AddProductToCheckoutUseCase
import br.com.example.domain.usecases.CalculateProductUseCase
import br.com.example.domain.usecases.GetProductListUseCase
import br.com.example.domain.usecases.GetSupplierListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetProductListUseCase> {
        GetProductListUseCase(
            get()
        )
    }
    factory {
        AddProductToCheckoutUseCase(
            get(),
            get()
        )
    }
    factory {
        GetSupplierListUseCase(
            get()
        )
    }
    factory { CalculateProductUseCase() }

}

val domainModule = listOf(useCaseModule)