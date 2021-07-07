package de.mycraftnote.code_channlenge.domain.usecase

import de.mycraftnote.code_channlenge.domain.repository.ProjectsRepository

class GetFolderProjectsUseCase(private val repository: ProjectsRepository) {
  suspend operator fun invoke() = repository.getFolderProjects()
}