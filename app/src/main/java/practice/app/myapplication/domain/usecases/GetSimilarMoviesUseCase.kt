package practice.app.myapplication.domain.usecases

import io.reactivex.Single
import practice.app.myapplication.domain.Repository
import practice.app.myapplication.domain.entities.MovieEntity

class GetSimilarMoviesUseCase(private val repository: Repository) {
    fun getSimilarMovies(movieId: Int): Single<List<MovieEntity>> {
        return repository.getSimilarMovies(movieId)
    }
}