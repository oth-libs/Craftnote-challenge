package de.mycraftnote.code_channlenge.presentation.ui.task.projects

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.viewModelScope
import de.mycraftnote.code_channlenge.domain.datasource.DataSourceResultHolder
import de.mycraftnote.code_channlenge.domain.model.ProjectModel
import de.mycraftnote.code_channlenge.domain.usecase.GetFolderProjectsUseCase
import de.mycraftnote.code_channlenge.presentation.BaseViewModel
import de.mycraftnote.code_channlenge.presentation.livedata.SingleLiveEvent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ProjectsViewModel(
  private val getFolderProjectsUseCase: GetFolderProjectsUseCase
) : BaseViewModel() {

  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // __      ___                 _      _           _____        _
  // \ \    / (_)               | |    (_)         |  __ \      | |
  //  \ \  / / _  _____      __ | |     ___   _____| |  | | __ _| |_ __ _
  //   \ \/ / | |/ _ \ \ /\ / / | |    | \ \ / / _ \ |  | |/ _` | __/ _` |
  //    \  /  | |  __/\ V  V /  | |____| |\ V /  __/ |__| | (_| | || (_| |
  //     \/   |_|\___| \_/\_/   |______|_| \_/ \___|_____/ \__,_|\__\__,_|
  //
  //Font Name: Big
  /**
   * For updating ui loading/error..
   */
  private val _statusUpdated = SingleLiveEvent<DataSourceResultHolder.Status>()
  val statusUpdated: LiveData<DataSourceResultHolder.Status> = _statusUpdated

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
  fun getFolderProjects() {
    viewModelScope.launch {
      getFolderProjectsUseCase().collect {

        _statusUpdated.value = it.status
        it.data?.projects?.let { _dataReceived.value = it }

      }
    }
  }

}