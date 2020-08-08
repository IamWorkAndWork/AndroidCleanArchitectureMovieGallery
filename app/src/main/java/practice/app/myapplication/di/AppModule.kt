package practice.app.myapplication.di

import org.koin.dsl.module
import practice.app.myapplication.presentation.mapper.MovieMapper
import practice.app.myapplication.presentation.viewmodel.BaseSchedulerProvider
import practice.app.myapplication.presentation.viewmodel.SchedulerProvider

val appModule = module {

    single<BaseSchedulerProvider> {
        SchedulerProvider()
    }

    single {
        provideMoviesMapper()
    }

}

fun provideMoviesMapper(): MovieMapper {
    return MovieMapper()
}
