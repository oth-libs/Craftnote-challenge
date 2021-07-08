package de.mycraftnote.code_channlenge.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ProjectsRetrofitModel(
  @SerialName("projects") val projects: List<ProjectRetrofitModel>? = null
)

@Serializable
internal data class ProjectRetrofitModel(
  @SerialName("id") val id: String? = null,
  @SerialName("name") val name: String? = null,
  @SerialName("projectType") val projectType: String? = null,
  @SerialName("creationDate") val creationDate: Int? = null,
  @SerialName("lastOpenedDate") val lastOpenedDate: Int? = null,
  @SerialName("street") val street: String? = null,
  @SerialName("zipcode") val zipcode: String? = null,
  @SerialName("city") val city: String? = null,
  @SerialName("country") val country: String? = null,
)
