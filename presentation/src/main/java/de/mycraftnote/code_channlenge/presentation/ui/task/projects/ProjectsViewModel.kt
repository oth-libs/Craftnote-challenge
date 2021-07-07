package de.mycraftnote.code_channlenge.presentation.ui.task.projects

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.viewModelScope
import de.mycraftnote.code_channlenge.domain.model.ProjectModel
import de.mycraftnote.code_channlenge.domain.usecase.GetFolderProjectsUseCase
import de.mycraftnote.code_channlenge.presentation.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProjectsViewModel(
  private val getFolderProjectsUseCase: GetFolderProjectsUseCase
) : BaseViewModel() {

  /**
   * data received
   */
  private val _dataReceived = MutableLiveData<List<ProjectModel>>()
  val dataReceived: LiveData<List<ProjectModel>> = _dataReceived

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //  _    _           _____
  // | |  | |         / ____|
  // | |  | |___  ___| |     __ _ ___  ___
  // | |  | / __|/ _ \ |    / _` / __|/ _ \
  // | |__| \__ \  __/ |___| (_| \__ \  __/
  //  \____/|___/\___|\_____\__,_|___/\___|
  //
  //Font Name: Big
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  @Suppress("UNUSED")
  fun getCachedUrls() {
    viewModelScope.launch {
      getFolderProjectsUseCase().collect {

        it.data?.projects?.let { _dataReceived.value = it }

      }
    }
  }

}