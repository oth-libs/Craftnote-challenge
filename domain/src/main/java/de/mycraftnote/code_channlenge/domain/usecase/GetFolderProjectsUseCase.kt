package de.mycraftnote.code_channlenge.domain.usecase

import de.mycraftnote.code_channlenge.domain.datasource.DataSourceResultHolder
import de.mycraftnote.code_channlenge.domain.model.ProjectsModel
import de.mycraftnote.code_channlenge.domain.repository.ProjectsRepository
import kotlinx.coroutines.flow.Flow

class GetFolderProjectsUseCase(private val repository: ProjectsRepository) {
  operator fun invoke(): Flow<DataSourceResultHolder<ProjectsModel>> = repository.getFolderProjects()
}