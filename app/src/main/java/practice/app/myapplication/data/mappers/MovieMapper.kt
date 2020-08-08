package practice.app.myapplication.data.mappers

import practice.app.myapplication.data.models.MovieModel
import practice.app.myapplication.domain.entities.MovieEntity

class MovieMapper : DataToDomainMapper<MovieModel, MovieEntity> {
    override fun mapFromDataToDomainModel(model: MovieModel): MovieEntity {
        return MovieEntity(
            adult = model.adult,
            title = model.title,
            releaseDate = model.releaseDate,
            posterPath = model.posterPath,
            popularity = model.popularity,
            overView = model.overview,
            originalTitle = model.originalTitle,
            originalLanguage = model.originalLanguage,
            id = model.id,
            genreIds = model.genreIds,
            backdropPath = model.backdropPath,
            video = model.video,
            voteAverage = model.voteAverage,
            voteCount = model.voteCount
        )
    }
}