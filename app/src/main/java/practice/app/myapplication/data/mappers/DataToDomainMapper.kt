package practice.app.myapplication.data.mappers

interface DataToDomainMapper<R, E> {
    fun mapFromDataToDomainModel(model: R): E
}