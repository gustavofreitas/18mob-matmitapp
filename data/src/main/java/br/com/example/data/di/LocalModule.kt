package br.com.example.data.di

import br.com.example.data.local.database.CheckoutDataBase
import br.com.example.data.local.datasource.CheckoutDataSource
import br.com.example.data.local.datasource.CheckoutDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localDataModule = module {
    single { CheckoutDataBase.createDataBase(androidContext()) }
    factory<CheckoutDataSource> {
        CheckoutDataSourceImpl(checkoutDao = get()) }
}