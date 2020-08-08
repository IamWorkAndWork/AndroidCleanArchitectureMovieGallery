package practice.app.myapplication.presentation.view.home

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.functions.Consumer
import practice.app.myapplication.domain.usecases.GetTopRatedMoviesUseCase
import practice.app.myapplication.presentation.mapper.MovieMapper
import practice.app.myapplication.presentation.models.MovieUIModel
import practice.app.myapplication.presentation.utils.ViewState
import practice.app.myapplication.presentation.viewmodel.BaseSchedulerProvider
import practice.app.myapplication.presentation.viewmodel.BaseViewModel

class HomeViewModel(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val movieMapper: MovieMapper,
    private val baseSchedulerProvider: BaseSchedulerProvider
) : BaseViewModel(baseSchedulerProvider = baseSchedulerProvider), LifecycleObserver {

    val topRatedMovies = MutableLiveData<ViewState<List<MovieUIModel>>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun getTopRatedMovies() {
        execute(
            loadingConsumer = Consumer {
                topRatedMovies.postValue(
                    ViewState.loading()
                )
            },
            throwableConsumer = Consumer {
                topRatedMovies.postValue(
                    ViewState.error(it.message)
                )
            },
            successConsumer = Consumer {
                topRatedMovies.postValue(
                    ViewState.success(
                        it.map { movie ->
                            movieMapper.mapFromDomainToPresentation(movie)
                        }
                    )
                )
            },
            usecase = getTopRatedMoviesUseCase.getTopRatedMovies()
        )
    }

}