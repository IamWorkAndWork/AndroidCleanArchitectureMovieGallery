package practice.app.myapplication.data.remotedatasource

import io.reactivex.Single
import practice.app.myapplication.data.models.MovieModel
import practice.app.myapplication.data.models.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceApi {

    @GET("/3/movie/top_rated")
    fun getTopRatedMovie(): Single<MovieResponse>

    @GET("/3/movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: Int): Single<MovieModel>

    @GET("/3/movie/{movie_id}/recommendations")
    fun getRecommend(@Path("movie_id") movieId: Int): Single<MovieResponse>

    @GET("/3/movie/{movie_id}/similar")
    fun getSimilarMovies(@Path("movie_id") movieId: Int): Single<MovieResponse>

}