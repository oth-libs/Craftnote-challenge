package de.mycraftnote.code_channlenge.data.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import de.mycraftnote.code_channlenge.data.BuildConfig
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

internal class RetrofitFactory {

  @ExperimentalSerializationApi fun build(json: Json): Retrofit {
    return Retrofit.Builder()
      .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
      .client(getClient())
      .baseUrl(BuildConfig.BASE_API)
      .build()
  }

  private fun getClient(): OkHttpClient {
    val builder = OkHttpClient.Builder()

    addBearerInterceptor(builder)
    addTimeouts(builder)

    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    builder.addInterceptor(interceptor)

    return builder.build()
  }

  private fun addBearerInterceptor(builder: OkHttpClient.Builder) {
    builder.addInterceptor { chain ->

      val newRequest = chain.request()
        .newBuilder()
        .addHeader("X-CN-API-KEY", "c322f488-05e7-4f4a-a2b3-41a4f31af501")
        .build()
      chain.proceed(newRequest)
    }
  }

  private fun addTimeouts(builder: OkHttpClient.Builder, timeout: Int = 30) {
    builder.connectTimeout(timeout.toLong(), TimeUnit.SECONDS)
      .writeTimeout(timeout.toLong(), TimeUnit.SECONDS)
      .readTimeout(timeout.toLong(), TimeUnit.SECONDS)
  }
}