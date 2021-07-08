package de.mycraftnote.code_channlenge.data.factory

import de.mycraftnote.code_channlenge.data.remote.model.ProjectRetrofitModel
import de.mycraftnote.code_channlenge.data.remote.model.ProjectsRetrofitModel
import de.mycraftnote.code_channlenge.domain.model.ProjectModel
import de.mycraftnote.code_channlenge.domain.model.ProjectsModel
import java.util.Calendar

internal object Factory {

  val retrofitModel1 = ProjectRetrofitModel(
    id = "id1",
    name = "name1",
    projectType = "FOLDER",
    creationDate = 1611163220,
    lastOpenedDate = 1611158420,
    street = "street1",
    zipcode = "zipcode1",
    city = "city1",
    country = "country1",
  )

  val retrofitModel2 = ProjectRetrofitModel(
    id = "id2",
    name = "name2",
    projectType = "PROJECT",
    creationDate = 1611163220,
    lastOpenedDate = 1611158420,
    street = "street2",
    zipcode = "zipcode2",
    city = "city2",
    country = "country2",
  )

  val projectsRetrofitModel1 = ProjectsRetrofitModel(
    projects = listOf(retrofitModel1, retrofitModel2)
  )

  val model1 = ProjectModel(
    id = "id1",
    name = "name1",
    projectType = "FOLDER",
    creationDate = Calendar.getInstance().apply { timeInMillis = retrofitModel1.creationDate!!.toLong() * 1000 },
    lastOpenedDate = Calendar.getInstance().apply { timeInMillis = retrofitModel1.lastOpenedDate!!.toLong() * 1000 },
    street = "street1",
    zipcode = "zipcode1",
    city = "city1",
    country = "country1",
  )

  val projectsModel1 = ProjectsModel(
    projects = listOf(model1)
  )
}