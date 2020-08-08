package practice.app.myapplication.di

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import java.util.concurrent.TimeUnit
import kotlin.math.log

val httpModule = module {

    single<ApiKeyInterceptor> {
        provideApiKeyInterceptor()
    }

    single<HttpLoggingInterceptor> {
        provideHttpLoggingInterceptor()
    }

    single<OkHttpClient> {
        provieHttpClient(
            interceptor = get(),
            loggingInterceptor = get()
        )
    }

}

fun provieHttpClient(
    interceptor: ApiKeyInterceptor,
    loggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .addInterceptor(loggingInterceptor)
        .build()
}

fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return logging
}

private fun provideApiKeyInterceptor(): ApiKeyInterceptor {
    return ApiKeyInterceptor()
}
