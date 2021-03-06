package br.com.example.domain.di

import br.com.example.domain.usecases.*
import org.koin.dsl.module

val useCaseModule = module {
    factory {
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
        GetCheckoutUseCase(
            get()
        )
    }
    factory {
        GetSupplierListUseCase(
            get()
        )
    }
    factory {
        BuyUseCase(
            get()
        )
    }
    factory {
        CheckoutEmptyUseCase(
            get()
        )
    }
    factory { CalculateProductUseCase() }

    factory { SignUpUseUseCase(get()) }
    factory { SignInUserUseCase(get()) }
    factory { HasLoggedUserUserCase(get()) }

}

val domainModule = listOf(useCaseModule)