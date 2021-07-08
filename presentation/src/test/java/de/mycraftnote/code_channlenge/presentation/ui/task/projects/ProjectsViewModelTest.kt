package de.mycraftnote.code_channlenge.presentation.ui.task.projects

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import de.mycraftnote.code_channlenge.domain.datasource.DataSourceResultHolder
import de.mycraftnote.code_channlenge.domain.usecase.GetFolderProjectsUseCase
import de.mycraftnote.code_channlenge.presentation.TestCoroutineRule
import de.mycraftnote.code_channlenge.presentation.factory.Factory
import de.mycraftnote.code_channlenge.presentation.getOrAwaitValue
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeoutException
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class ProjectsViewModelTest {

  @get:Rule
  val rule = InstantTaskExecutorRule()

  @get:Rule
  val testCoroutineRule = TestCoroutineRule()

  private val lifecycle = LifecycleRegistry(mockk())

  private val getFolderProjectsUseCase: GetFolderProjectsUseCase = mockk()

  private val viewModel = ProjectsViewModel(getFolderProjectsUseCase = getFolderProjectsUseCase)

  @Test
  fun `When lifecycle#ON_RESUME, then verify getFolderProjectsUseCase is called`() {
    every { getFolderProjectsUseCase() } returns flowOf(DataSourceResultHolder.success(Factory.projectsModel1))

    lifecycle.addObserver(viewModel)

    lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)

    verify(exactly = 1) { getFolderProjectsUseCase() }
  }

  @Test
  fun `When viewModel#getFolderProjects is called, then verify getFolderProjectsUseCase and success result`() {
    every { getFolderProjectsUseCase() } returns flowOf(DataSourceResultHolder.success(Factory.projectsModel1))

    viewModel.getFolderProjects()

    verify(exactly = 1) { getFolderProjectsUseCase() }
    assertEquals(viewModel.statusUpdated.getOrAwaitValue(), DataSourceResultHolder.Status.SUCCESS)
    assertEquals(viewModel.dataReceived.getOrAwaitValue(), Factory.projectsModel1.projects)
  }

  @Test
  fun `When viewModel#getFolderProjects is called, then verify getFolderProjectsUseCase and error result`() {
    every { getFolderProjectsUseCase() } returns flowOf(DataSourceResultHolder.error())

    viewModel.getFolderProjects()

    verify(exactly = 1) { getFolderProjectsUseCase() }
    assertEquals(viewModel.statusUpdated.getOrAwaitValue(), DataSourceResultHolder.Status.ERROR)

    try {
      viewModel.dataReceived.getOrAwaitValue()
    } catch (e: Exception) {
      assertEquals(TimeoutException::class, e::class)
    }

  }
}