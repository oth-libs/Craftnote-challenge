package de.mycraftnote.code_channlenge.domain.model

data class ProjectsModel(
  val projects: List<ProjectModel>?
)

data class ProjectModel(
  val id: String?,
  val name: String?,
  val projectType: String?,
  val startDate: Int?,
  val street: String?,
  val zipcode: String?,
  val city: String?,
  val country: String?,
) {
  fun getNameFirstLetter() = name?.get(0)?.toString() ?: String()

  fun getAddress() = run {
    if (street.isNullOrBlank() && zipcode.isNullOrBlank() && city.isNullOrBlank() && country.isNullOrBlank()) null
    else "$street $zipcode, $city, $country"
  }

  fun hasAddress() = getAddress() != null
}
