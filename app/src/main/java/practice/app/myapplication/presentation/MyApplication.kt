package practice.app.myapplication.presentation

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import practice.app.myapplication.di.*

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()

    }

    private fun initKoin() {

        startKoin {
            androidContext(this@MyApplication)
            modules(
                appModule, httpModule, repositoryModule, retrofitModule, useCasesModule,
                HomeViewModelModule
            )
        }

    }

}