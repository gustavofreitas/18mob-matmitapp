package br.com.example.data.di

import br.com.example.data.local.database.CheckoutDataBase
import br.com.example.data.local.datasource.CheckoutDataSource
import br.com.example.data.local.datasource.CheckoutDataSourceImpl
import br.com.example.data.remote.datasource.*
import br.com.example.data.repository.CheckoutRepositoryImpl
import br.com.example.data.repository.ProductRepositoryImpl
import br.com.example.data.repository.SecurityRepositoryImpl
import br.com.example.data.repository.SupplierRepositoryImpl
import br.com.example.domain.repository.CheckoutRepository
import br.com.example.domain.repository.ProductRepository
import br.com.example.domain.repository.SecurityRepository
import br.com.example.domain.repository.SupplierRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val remoteDataModule = module{

    single{ FirebaseFirestore.getInstance()}
    single{ FirebaseAuth.getInstance()}

    factory<ProductDataSource> {
        ProductDataSourceImpl(get())
    }

    factory<SupplierDataSource> {
        SupplierDataSourceImpl(get())
    }

    factory<SecurityDataSource> {
        SecurityDataSourceImpl(get())
    }

}

val localDataModule = module {
    single { CheckoutDataBase.createDataBase(androidContext()) }
    factory<CheckoutDataSource> {
        CheckoutDataSourceImpl(checkoutDao = get()) }
}

val repositoryDataModule = module{

    single {}

    factory<CheckoutRepository> {
        CheckoutRepositoryImpl(get())
    }

    factory<ProductRepository> {
        ProductRepositoryImpl(get())
    }

    factory<SupplierRepository> {
        SupplierRepositoryImpl(get())
    }

    factory<SecurityRepository> {
        SecurityRepositoryImpl(get())
    }

}

val dataModule = listOf(
    repositoryDataModule,
    localDataModule,
    remoteDataModule
)