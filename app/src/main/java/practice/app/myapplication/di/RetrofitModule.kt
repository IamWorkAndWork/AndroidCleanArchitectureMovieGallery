package practice.app.myapplication.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.dsl.module
import practice.app.myapplication.data.remotedatasource.ServiceApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.sin

private const val BASE_URL = "https://api.themoviedb.org/"

val retrofitModule = module {

    single {
        provideRetrofit(
            okHttpClient = get(),
            gson = get()
        )
    }

    single<Gson> {
        provideGSON()
    }

    single<ServiceApi> {
        provideAuthorizedServiceApi(
            retrofit = get()
        )
    }

}

fun provideGSON(): Gson {
    return GsonBuilder().create()
}

fun provideAuthorizedServiceApi(retrofit: Retrofit): ServiceApi {
    return retrofit.create(ServiceApi::class.java)
}

fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gson: Gson
): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}