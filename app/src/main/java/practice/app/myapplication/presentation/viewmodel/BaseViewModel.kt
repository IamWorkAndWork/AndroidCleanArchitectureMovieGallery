package practice.app.myapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

open class BaseViewModel(
    private val baseSchedulerProvider: BaseSchedulerProvider
) : ViewModel() {

    private val subscribeOn = baseSchedulerProvider.io()
    private val observeOn = baseSchedulerProvider.ui()
    private val disposables = CompositeDisposable()

    protected fun <T> execute(
        loadingConsumer: Consumer<Disposable>,
        successConsumer: Consumer<T>,
        throwableConsumer: Consumer<Throwable>,
        usecase: Single<T>
    ) {
        val observable = usecase
            .doOnSubscribe(loadingConsumer)
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
        addDisposable(observable.subscribe(successConsumer, throwableConsumer))
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    private fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    override fun onCleared() {
        super.onCleared()
        dispose()
    }

}