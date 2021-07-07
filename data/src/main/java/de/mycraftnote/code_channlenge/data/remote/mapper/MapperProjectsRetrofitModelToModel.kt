package de.mycraftnote.code_channlenge.data.remote.mapper

import de.mycraftnote.code_channlenge.data.mapper.Mapper
import de.mycraftnote.code_channlenge.data.remote.model.ProjectRetrofitModel
import de.mycraftnote.code_channlenge.data.remote.model.ProjectsRetrofitModel
import de.mycraftnote.code_channlenge.domain.model.ProjectModel
import de.mycraftnote.code_channlenge.domain.model.ProjectsModel

/**
 * Map [ProjectsRetrofitModel] to [ProjectModel], leaves only FOLDER projects, sort by creationDate
 */
internal object MapperProjectsRetrofitModelToModel : Mapper<ProjectsRetrofitModel, ProjectsModel> {

  private const val FOLDER_TYPE = "FOLDER"

  override fun map(from: ProjectsRetrofitModel): ProjectsModel {
    return from.run {
      ProjectsModel(
        projects = mapsProjects(from.projects)
      )
    }
  }

  private fun mapsProjects(projects: List<ProjectRetrofitModel>?): List<ProjectModel>? {
    return projects?.let {
      mutableListOf<ProjectModel>().apply {
        projects.filter { it.projectType.equals(FOLDER_TYPE, true) }.forEach { project ->

          val projectModel = ProjectModel(
            id = project.id,
            name = project.name,
            projectType = project.projectType,
            creationDate = project.creationDate,
            street = project.street,
            zipcode = project.zipcode,
            city = project.city,
            country = project.country
          )

          add(projectModel)
        }
      }.sortedByDescending { it.creationDate }
    }
  }

}