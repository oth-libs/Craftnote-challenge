package de.mycraftnote.code_challenge

import android.app.Application
import de.mycraftnote.code_channlenge.domain.di.DomainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("UNUSED")
class CNApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidContext(this@CNApplication)
    }

    loadModules()
  }

  @Suppress("EXPERIMENTAL_API_USAGE")
  private fun loadModules() {
    DomainModule.load()
//    DataModule.load()
//    PresentationModule.load()
  }
}
