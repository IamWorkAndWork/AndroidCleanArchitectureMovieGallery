package practice.app.myapplication.domain.usecases

import io.reactivex.Single
import practice.app.myapplication.domain.Repository
import practice.app.myapplication.domain.entities.MovieEntity

class GetRecommendedMoviesUseCase(private val repository: Repository) {
    fun getReccommendMovies(movieId: Int): Single<List<MovieEntity>> {
        return repository.getReccommendMovies(movieId)
    }
}