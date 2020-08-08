package practice.app.myapplication.data.repository

import io.reactivex.Single
import org.koin.java.KoinJavaComponent.inject
import practice.app.myapplication.data.mappers.MovieMapper
import practice.app.myapplication.data.remotedatasource.ServiceApi
import practice.app.myapplication.domain.Repository
import practice.app.myapplication.domain.entities.MovieEntity

class RepositoryImplementer(
    private val serviceApi: ServiceApi,
    private val movieMapper: MovieMapper
) : Repository {

    override fun getTopRatedMovies(): Single<List<MovieEntity>> {
        return serviceApi.getTopRatedMovie().map { response ->
            response.movieModels.map { movieModel ->
                movieMapper.mapFromDataToDomainModel(movieModel)
            }
        }
    }

    override fun getMovieDetails(movieId: Int): Single<MovieEntity> {
        return serviceApi.getMovieDetail(movieId).map { movieModel ->
            movieMapper.mapFromDataToDomainModel(movieModel)
        }
    }

    override fun getSimilarMovies(movieId: Int): Single<List<MovieEntity>> {
        return serviceApi.getSimilarMovies(movieId).map { response ->
            response.movieModels.map { movieModel ->
                movieMapper.mapFromDataToDomainModel(movieModel)
            }
        }
    }

    override fun getReccommendMovies(movieId: Int): Single<List<MovieEntity>> {
        return serviceApi.getRecommend(movieId).map { response ->
            response.movieModels.map { movieModel ->
                movieMapper.mapFromDataToDomainModel(movieModel)
            }
        }
    }


}