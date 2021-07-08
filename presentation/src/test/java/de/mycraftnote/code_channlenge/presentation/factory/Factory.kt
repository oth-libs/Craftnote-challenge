package de.mycraftnote.code_channlenge.presentation.factory

import de.mycraftnote.code_channlenge.domain.model.ProjectModel
import de.mycraftnote.code_channlenge.domain.model.ProjectsModel
import java.util.Calendar

internal object Factory {

  val model1 = ProjectModel(
    id = "id1",
    name = "name1",
    projectType = "FOLDER",
    creationDate = Calendar.getInstance().apply { timeInMillis = 1611163220.toLong() * 1000 },
    lastOpenedDate = Calendar.getInstance().apply { timeInMillis = 1611163220.toLong() * 1000 },
    street = "street1",
    zipcode = "zipcode1",
    city = "city1",
    country = "country1",
  )

  val model2 = ProjectModel(
    id = "id2",
    name = "name2",
    projectType = "FOLDER",
    creationDate = Calendar.getInstance().apply { timeInMillis = 1611163220.toLong() * 1000 },
    lastOpenedDate = Calendar.getInstance().apply { timeInMillis = 1611163220.toLong() * 1000 },
    street = "street2",
    zipcode = "zipcode2",
    city = "city2",
    country = "country2",
  )

  val projectsModel1 = ProjectsModel(
    projects = listOf(model1, model2)
  )
}