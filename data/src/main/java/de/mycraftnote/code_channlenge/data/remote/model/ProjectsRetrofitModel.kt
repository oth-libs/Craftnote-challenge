package de.mycraftnote.code_channlenge.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProjectsRetrofitModel(
  @SerialName("projects") val projects: List<ProjectRetrofitModel>
)

@Serializable
data class ProjectRetrofitModel(
  @SerialName("id") val id: String?,
  @SerialName("name") val name: String?,
  @SerialName("projectType") val projectType: String?,
  @SerialName("startDate") val startDate: Int?,
  @SerialName("street") val street: String?,
  @SerialName("zipcode") val zipcode: String?,
  @SerialName("city") val city: String?,
  @SerialName("country") val country: String?,
)
