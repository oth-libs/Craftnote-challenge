package de.mycraftnote.code_channlenge.domain.di

import de.mycraftnote.code_channlenge.domain.usecase.GetFolderProjectsUseCase
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

object DomainModule {

  fun load() {
    loadKoinModules(module {
      single { GetFolderProjectsUseCase(repository = get()) }
    })
  }
}