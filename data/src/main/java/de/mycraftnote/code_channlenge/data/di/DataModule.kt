package de.mycraftnote.code_channlenge.data.di

import de.mycraftnote.code_channlenge.data.remote.RetrofitFactory
import de.mycraftnote.code_channlenge.data.remote.api.ProjectsService
import de.mycraftnote.code_channlenge.data.repository.ProjectsRepositoryImp
import de.mycraftnote.code_channlenge.domain.repository.ProjectsRepository
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit

object DataModule {

  @ExperimentalSerializationApi fun load() {
    loadKoinModules(module {
      //JSON
      single { Json { ignoreUnknownKeys = true } }

      //  retrofit
      single { RetrofitFactory().build(json = get()) }
      single { (get() as Retrofit).create(ProjectsService::class.java) }

      // repository
      single<ProjectsRepository> { ProjectsRepositoryImp(projectsService = get()) }
    })
  }
}