package de.mycraftnote.code_channlenge.domain.datasource

/**
 * A class that holds a value with its loading status.
 */
data class DataSourceResultHolder<out MODEL>(
  val status: Status,
  val data: MODEL?
) {

  enum class Status {
    IN_PROGRESS,
    NO_INTERNET,
    SUCCESS,
    ERROR
  }

  companion object {
    fun <MODEL> inProgress(): DataSourceResultHolder<MODEL> {
      return DataSourceResultHolder(status = Status.IN_PROGRESS, data = null)
    }

    fun <MODEL> noInternet(): DataSourceResultHolder<MODEL> {
      return DataSourceResultHolder(status = Status.NO_INTERNET, data = null)
    }

    fun <MODEL> success(data: MODEL): DataSourceResultHolder<MODEL> {
      return DataSourceResultHolder(status = Status.SUCCESS, data = data)
    }

    fun <MODEL> error(): DataSourceResultHolder<MODEL> {
      return DataSourceResultHolder(status = Status.ERROR, data = null)
    }
  }
}