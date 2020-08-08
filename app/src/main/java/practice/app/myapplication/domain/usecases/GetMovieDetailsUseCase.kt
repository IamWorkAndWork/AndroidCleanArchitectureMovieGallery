package practice.app.myapplication.domain.usecases

import io.reactivex.Single
import practice.app.myapplication.domain.Repository
import practice.app.myapplication.domain.entities.MovieEntity

class GetMovieDetailsUseCase(private val repository: Repository) {
    fun getMovieDetails(movideId: Int): Single<MovieEntity> {
        return repository.getMovieDetails(movideId)
    }
}