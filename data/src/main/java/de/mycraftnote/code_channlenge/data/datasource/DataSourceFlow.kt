package de.mycraftnote.code_channlenge.data.datasource

import de.mycraftnote.code_channlenge.domain.datasource.DataSourceResultHolder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 *
 * [networkCall] - Calls the network and implicitly checks for internet connection and returns the result wrapped in a [DataSourceResultHolder]
 *
 * Function notify UI about:
 * [DataSourceResultHolder.Status.SUCCESS]
 * [DataSourceResultHolder.Status.ERROR]
 * [DataSourceResultHolder.Status.NO_INTERNET]
 * [DataSourceResultHolder.Status.IN_PROGRESS]
 */
internal fun <MODEL> resultFlow(
  networkCall: (suspend () -> DataSourceResultHolder<MODEL>)
): Flow<DataSourceResultHolder<MODEL>> {
  return flow {

    emit(DataSourceResultHolder.inProgress())

    val responseStatus = networkCall()

    emit(responseStatus)
  }
}