package practice.app.myapplication.domain

import io.reactivex.Single
import practice.app.myapplication.domain.entities.MovieEntity

interface Repository {

    fun getTopRatedMovies(): Single<List<MovieEntity>>

    fun getMovieDetails(mocieId: Int): Single<MovieEntity>

    fun getSimilarMovies(movieId: Int): Single<List<MovieEntity>>

    fun getReccommendMovies(movieId: Int): Single<List<MovieEntity>>

}