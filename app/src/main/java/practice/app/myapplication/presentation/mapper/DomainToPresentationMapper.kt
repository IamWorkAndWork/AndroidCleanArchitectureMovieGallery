package practice.app.myapplication.presentation.mapper

interface DomainToPresentationMapper<R, E> {
    fun mapFromDomainToPresentation(model: R): E
}