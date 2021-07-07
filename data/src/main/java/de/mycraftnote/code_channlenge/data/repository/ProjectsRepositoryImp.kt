package de.mycraftnote.code_channlenge.data.repository

import de.mycraftnote.code_channlenge.data.datasource.resultFlow
import de.mycraftnote.code_channlenge.data.remote.api.ProjectsService
import de.mycraftnote.code_channlenge.data.remote.datasource.RemoteDataSource
import de.mycraftnote.code_channlenge.data.remote.mapper.MapperProjectsRetrofitModelToModel
import de.mycraftnote.code_channlenge.domain.datasource.DataSourceResultHolder
import de.mycraftnote.code_channlenge.domain.model.ProjectsModel
import de.mycraftnote.code_channlenge.domain.repository.ProjectsRepository
import kotlinx.coroutines.flow.Flow

internal class ProjectsRepositoryImp(
  private val projectsService: ProjectsService,
) : ProjectsRepository {

  override fun getFolderProjects(): Flow<DataSourceResultHolder<ProjectsModel>> {
    return resultFlow(
      networkCall = {
        RemoteDataSource.getRemoteResult(
          call = { projectsService.getProjects() },
          map = { MapperProjectsRetrofitModelToModel.map(it) }
        )
      }
    )
  }
}