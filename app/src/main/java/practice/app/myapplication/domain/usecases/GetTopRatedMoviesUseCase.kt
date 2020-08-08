package practice.app.myapplication.domain.usecases

import io.reactivex.Single
import practice.app.myapplication.domain.Repository
import practice.app.myapplication.domain.entities.MovieEntity

class GetTopRatedMoviesUseCase(private val repository: Repository) {
    fun getTopRatedMovies(): Single<List<MovieEntity>> {
        return repository.getTopRatedMovies()
    }
}