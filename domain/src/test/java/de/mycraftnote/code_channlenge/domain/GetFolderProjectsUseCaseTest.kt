package de.mycraftnote.code_channlenge.domain

import de.mycraftnote.code_channlenge.domain.datasource.DataSourceResultHolder
import de.mycraftnote.code_channlenge.domain.factory.Factory
import de.mycraftnote.code_channlenge.domain.repository.ProjectsRepository
import de.mycraftnote.code_channlenge.domain.usecase.GetFolderProjectsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class GetFolderProjectsUseCaseTest {

  private val repository: ProjectsRepository = mockk()
  private val useCase: GetFolderProjectsUseCase by lazy { GetFolderProjectsUseCase(repository = repository) }

  private val expected =  flowOf(DataSourceResultHolder.success(Factory.model1))

  @Before
  fun setup() {
    coEvery { repository.getFolderProjects() } returns expected
  }

  @Test
  fun testGetFolderProjectsUseCase() = runBlocking {
    val result = useCase()

    assertEquals(expected, result)
  }
}