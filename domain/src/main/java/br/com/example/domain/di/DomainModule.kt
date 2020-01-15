package br.com.example.domain.di

import br.com.example.domain.usecases.AddProductToCheckoutUseCase
import br.com.example.domain.usecases.GetProductListUseCase
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
    }
}

val domainModule = listOf(useCaseModule)