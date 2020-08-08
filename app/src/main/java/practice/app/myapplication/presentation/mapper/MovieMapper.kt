package practice.app.myapplication.presentation.mapper

import practice.app.myapplication.domain.entities.MovieEntity
import practice.app.myapplication.presentation.models.MovieUIModel

class MovieMapper : DomainToPresentationMapper<MovieEntity, MovieUIModel> {
    override fun mapFromDomainToPresentation(model: MovieEntity): MovieUIModel {
        return MovieUIModel(
            adult = model.adult,
            title = model.title,
            releaseDate = model.releaseDate,
            posterPath = model.posterPath,
            popularity = model.popularity,
            overview = model.overView,
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