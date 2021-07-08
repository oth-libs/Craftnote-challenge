package de.mycraftnote.code_channlenge.domain.model

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

data class ProjectsModel(
  val projects: List<ProjectModel>?
)

data class ProjectModel(
  val id: String?,
  val name: String?,
  val projectType: String?,
  val creationDate: Calendar?,
  val lastOpenedDate: Calendar?,
  val street: String?,
  val zipcode: String?,
  val city: String?,
  val country: String?,
) {
  fun getNameFirstLetter() = name?.get(0)?.toString() ?: String() // replace with proper char for null

  fun getAddress() = run {
    if (street.isNullOrBlank() && zipcode.isNullOrBlank() && city.isNullOrBlank() && country.isNullOrBlank()) null
    else "$street $zipcode, $city, $country"
  }

  fun hasAddress() = getAddress() != null

  fun getLastOpenedDateFormatted(): String = lastOpenedDate?.let { SimpleDateFormat("E, MMM dd, yy", Locale.getDefault()).format(lastOpenedDate.time) } ?: String() // replace with proper char for null
}

