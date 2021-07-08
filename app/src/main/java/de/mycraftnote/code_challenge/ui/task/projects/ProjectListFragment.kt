package de.mycraftnote.code_challenge.ui.task.projects

import android.os.Bundle
import android.view.View
import de.mycraftnote.code_challenge.R
import de.mycraftnote.code_challenge.databinding.FragmentProjectListBinding
import de.mycraftnote.code_challenge.extensions.setup
import de.mycraftnote.code_challenge.extensions.showMessage
import de.mycraftnote.code_challenge.extensions.visibleOrGone
import de.mycraftnote.code_challenge.ui.BaseFragment
import de.mycraftnote.code_channlenge.domain.datasource.DataSourceResultHolder
import de.mycraftnote.code_channlenge.domain.model.ProjectModel
import de.mycraftnote.code_channlenge.presentation.ui.task.projects.ProjectsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProjectListFragment : BaseFragment<FragmentProjectListBinding>(
  layoutId = R.layout.fragment_project_list,
) {

  override val viewModel: ProjectsViewModel by viewModel()

  private val projectsAdapter by lazy { ProjectsAdapter(::onItemClick) }

  override fun setupBinding() {
    binding.viewModel = viewModel
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    setupViews()
    observeViewModelCalls()
  }

  private fun setupViews() {
    binding.rvProjects.apply {
      setup()
      adapter = projectsAdapter
    }
  }

  private fun observeViewModelCalls() {
    viewModel.dataReceived.observe(viewLifecycleOwner, ::updateAdapter)
    viewModel.statusUpdated.observe(viewLifecycleOwner, ::updateStatusUi)
  }

  private fun updateAdapter(shortUrls: List<ProjectModel>) {
    projectsAdapter.newData(shortUrls)
  }

  private fun updateStatusUi(status: DataSourceResultHolder.Status) {
    when (status) {
      DataSourceResultHolder.Status.IN_PROGRESS -> {
        toggleLoading(true)
      }
      DataSourceResultHolder.Status.NO_INTERNET -> {
        toggleLoading(false)
        activity?.showMessage(R.string.error_internet)
      }
      DataSourceResultHolder.Status.ERROR -> {
        toggleLoading(false)
        activity?.showMessage(R.string.error_generic)
      }
      DataSourceResultHolder.Status.SUCCESS -> {
        toggleLoading(false)
      }
    }
  }

  private fun toggleLoading(isLoading: Boolean) {
    binding.pbLoading.visibleOrGone(isLoading)
  }

  private fun onItemClick(projectModel: ProjectModel) {
    activity?.showMessage(getString(R.string.last_opened, projectModel.getLastOpenedDateFormatted()))
  }
}