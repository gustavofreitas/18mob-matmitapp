package br.com.example.marmitapp

import android.app.Application
import br.com.example.data.di.dataModule
import br.com.example.domain.di.domainModule
import br.com.example.marmitapp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarmitAppApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MarmitAppApplication)

            modules(domainModule + dataModule + listOf(presentationModule))

        }
    }

}