package de.mycraftnote.code_channlenge.presentation.di

import de.mycraftnote.code_channlenge.presentation.ui.task.projects.ProjectsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object PresentationModule {

  fun load() {
    loadKoinModules(module {
      viewModel { ProjectsViewModel() }
    })
  }
}