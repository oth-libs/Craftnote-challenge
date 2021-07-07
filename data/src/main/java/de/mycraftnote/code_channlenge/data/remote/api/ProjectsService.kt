package de.mycraftnote.code_channlenge.data.remote.api

import de.mycraftnote.code_channlenge.data.remote.model.ProjectsRetrofitModel
import retrofit2.Response
import retrofit2.http.GET

internal interface ProjectsService {

  @GET("projects")
  suspend fun getProjects(): Response<ProjectsRetrofitModel>

}
