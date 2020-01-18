package br.com.example.data.di

import br.com.example.data.local.database.CheckoutDataBase
import br.com.example.data.local.datasource.CheckoutDataSource
import br.com.example.data.local.datasource.CheckoutDataSourceImpl
import br.com.example.data.remote.datasource.ProductDataSource
import br.com.example.data.remote.datasource.ProductDataSourceImpl
import br.com.example.data.remote.datasource.SupplierDataSource
import br.com.example.data.remote.datasource.SupplierDataSourceImpl
import br.com.example.data.repository.CheckoutRepositoryImpl
import br.com.example.data.repository.ProductRepositoryImpl
import br.com.example.data.repository.SupplierRepositoryImpl
import br.com.example.domain.repository.CheckoutRepository
import br.com.example.domain.repository.ProductRepository
import br.com.example.domain.repository.SupplierRepository
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val remoteDataModule = module{

    single{ FirebaseFirestore.getInstance()}

    factory<ProductDataSource> {
        ProductDataSourceImpl(get())
    }

    factory<SupplierDataSource> {
        SupplierDataSourceImpl(get())
    }

}

val localDataModule = module {
    single { CheckoutDataBase.createDataBase(androidContext()) }
    factory<CheckoutDataSource> {
        CheckoutDataSourceImpl(checkoutDao = get()) }
}

val repositoryDataModule = module{

    factory<CheckoutRepository> {
        CheckoutRepositoryImpl(get())
    }

    factory<ProductRepository> {
        ProductRepositoryImpl(get())
    }

    factory<SupplierRepository> {
        SupplierRepositoryImpl(get())
    }

}

val dataModule = listOf(
    repositoryDataModule,
    localDataModule,
    remoteDataModule
)