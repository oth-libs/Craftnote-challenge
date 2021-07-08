package de.mycraftnote.code_channlenge.data.remote.mapper

import de.mycraftnote.code_channlenge.data.factory.Factory
import org.junit.Test
import kotlin.test.assertEquals

class MapperProjectsRetrofitModelToModelTest {

  @Test
  fun testMapper() {
    val expected = Factory.projectsModel1

    val result = MapperProjectsRetrofitModelToModel.map(Factory.projectsRetrofitModel1)

    assertEquals(expected, result)
  }

}