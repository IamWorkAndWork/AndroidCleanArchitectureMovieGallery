package practice.app.myapplication.di

import org.koin.dsl.module
import practice.app.myapplication.data.mappers.MovieMapper
import practice.app.myapplication.data.remotedatasource.ServiceApi
import practice.app.myapplication.data.repository.RepositoryImplementer
import practice.app.myapplication.domain.Repository
import kotlin.math.sin

val repositoryModule = module {

    single<MovieMapper> {
        provideMovieMapper()
    }

    single<Repository> {
        providesMoviesRepository(
            movieMapper = get(),
            serviceApi = get()
        )
    }

}

fun providesMoviesRepository(
    serviceApi: ServiceApi, movieMapper: MovieMapper
): Repository {
    return RepositoryImplementer(serviceApi, movieMapper)
}

fun provideMovieMapper(): MovieMapper {
    return MovieMapper()
}
