package de.mycraftnote.code_channlenge.data.remote.datasource

import de.mycraftnote.code_channlenge.domain.datasource.DataSourceResultHolder
import retrofit2.Response
import java.io.IOException

internal object RemoteDataSource {

  /**
   * Get single RETROFIT response
   */
  suspend fun <MODEL_API, MODEL> getRemoteResult(
    call: suspend () -> Response<MODEL_API>,
    map: suspend (MODEL_API) -> MODEL,
  ): DataSourceResultHolder<MODEL> {

    try {
      val response = call()

      return when {
        response.isSuccessful && response.body() != null -> {
          val model = map(response.body()!!)
          DataSourceResultHolder.success(model)
        }

        else -> {
          DataSourceResultHolder.error()
        }
      }

    } catch (e: Exception) {
      e.printStackTrace()
      return if (e is IOException) {
        DataSourceResultHolder.noInternet()
      } else {
        DataSourceResultHolder.error()
      }
    }
  }
}