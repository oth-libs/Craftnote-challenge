package de.mycraftnote.code_channlenge.domain.repository

import de.mycraftnote.code_channlenge.domain.datasource.DataSourceResultHolder
import de.mycraftnote.code_channlenge.domain.model.ProjectModel
import de.mycraftnote.code_channlenge.domain.model.ProjectsModel
import kotlinx.coroutines.flow.Flow

interface ProjectsRepository {
  fun getFolderProjects(): Flow<DataSourceResultHolder<ProjectsModel>>
}