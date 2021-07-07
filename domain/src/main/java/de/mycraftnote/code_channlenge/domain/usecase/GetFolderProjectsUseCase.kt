package de.mycraftnote.code_channlenge.domain.usecase

import de.mycraftnote.code_channlenge.domain.repository.ProjectsRepository

class GetFolderProjectsUseCase(private val repository: ProjectsRepository) {
  operator fun invoke() = repository.getFolderProjects()
}