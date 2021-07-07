package de.mycraftnote.code_channlenge.domain.repository

import de.mycraftnote.code_channlenge.domain.datasource.DataSourceResultHolder
import de.mycraftnote.code_channlenge.domain.model.ProjectModel
import kotlinx.coroutines.flow.Flow

interface ProjectsRepository {
  fun getFolderProjects(): Flow<DataSourceResultHolder<ProjectModel>>
}