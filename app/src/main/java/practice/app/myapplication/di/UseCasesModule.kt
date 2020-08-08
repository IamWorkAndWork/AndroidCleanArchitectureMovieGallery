package practice.app.myapplication.di

import org.koin.dsl.module
import practice.app.myapplication.domain.Repository
import practice.app.myapplication.domain.usecases.GetMovieDetailsUseCase
import practice.app.myapplication.domain.usecases.GetRecommendedMoviesUseCase
import practice.app.myapplication.domain.usecases.GetSimilarMoviesUseCase
import practice.app.myapplication.domain.usecases.GetTopRatedMoviesUseCase

val useCasesModule = module {

    single {
        provideGetTopRatedUseCase(
            repository = get()
        )
    }

    single {
        provideGetMovieDetailsUseCase(
            repository = get()
        )
    }

    single {
        provideGetRecommendedMoviesUseCase(
            repository = get()
        )
    }

    single {
        provideGetSimilarMoviesUseCase(
            repository = get()
        )
    }

}

fun provideGetSimilarMoviesUseCase(repository: Repository): GetSimilarMoviesUseCase {
    return GetSimilarMoviesUseCase(repository)
}

fun provideGetRecommendedMoviesUseCase(repository: Repository): GetRecommendedMoviesUseCase {
    return GetRecommendedMoviesUseCase(repository)
}

fun provideGetMovieDetailsUseCase(repository: Repository): GetMovieDetailsUseCase {
    return GetMovieDetailsUseCase(repository)
}

fun provideGetTopRatedUseCase(repository: Repository): GetTopRatedMoviesUseCase {
    return GetTopRatedMoviesUseCase(repository)
}
