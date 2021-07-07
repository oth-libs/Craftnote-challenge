package de.mycraftnote.code_challenge.ui.task.projects

import de.mycraftnote.code_challenge.R
import de.mycraftnote.code_challenge.databinding.FragmentProjectListBinding
import de.mycraftnote.code_challenge.ui.BaseFragment
import de.mycraftnote.code_channlenge.presentation.ui.task.projects.ProjectsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProjectListFragment : BaseFragment<FragmentProjectListBinding>(
  layoutId = R.layout.fragment_project_list,
) {

  override val viewModel: ProjectsViewModel by viewModel()

  override fun setupBinding() {
    binding.viewModel = viewModel
  }

}