package practice.app.myapplication.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import practice.app.myapplication.presentation.view.home.HomeViewModel

val HomeViewModelModule = module {

    viewModel {
        HomeViewModel(
            baseSchedulerProvider = get(),
            movieMapper = get(),
            getTopRatedMoviesUseCase = get()
        )
    }

}