package de.mycraftnote.code_channlenge.data.repository

import de.mycraftnote.code_channlenge.data.factory.Factory
import de.mycraftnote.code_channlenge.data.remote.api.ProjectsService
import de.mycraftnote.code_channlenge.domain.datasource.DataSourceResultHolder
import de.mycraftnote.code_channlenge.domain.repository.ProjectsRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import kotlin.test.assertEquals

internal class ProjectsRepositoryTest {

  private val projectsService: ProjectsService = mockk(relaxed = true)

  private val repository: ProjectsRepository by lazy {
    ProjectsRepositoryImp(
      projectsService = projectsService,
    )
  }

  @Before
  fun setup() {
    coEvery { projectsService.getProjects() } returns Response.success(Factory.projectsRetrofitModel1)
  }

  @Test
  fun testGetProjects() = runBlocking {
    val expected = DataSourceResultHolder.success(Factory.projectsModel1)

    val result = repository.getFolderProjects().last()

    assertEquals(expected, result)
  }
}