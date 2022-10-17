package com.uranium.gitlist.main.presentation.repositorieslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uranium.gitlist.main.domain.usecase.GetKotlinRepositoriesUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

internal class RepositoriesListViewModel(
    private val getKotlinRepositoriesUseCase: GetKotlinRepositoriesUseCase
) : ViewModel() {

    private val repositoriesListState: MutableLiveData<RepositoriesListState> =
        MutableLiveData(RepositoriesListState())

    private var nextPage = 0

    fun getUser(): LiveData<RepositoriesListState> {
        return repositoriesListState
    }

    init {
        getKotlinRepositories(nextPage)
    }

    fun getKotlinRepositories(){
        getKotlinRepositories(nextPage)
    }

    private fun getKotlinRepositories(pageIndex: Int) {
        nextPage = pageIndex + 1
        viewModelScope.launch {
            getKotlinRepositoriesUseCase.invoke(nextPage)
                .onStart { shouldShowLoading(true) }
                .onCompletion { shouldShowLoading(false) }
                .catch { handleError(it) }
                .map { GitRepositoryMapper().mapToState(it) }
                .collect(::handleSuccess)
        }
    }

    private fun shouldShowLoading(isLoading: Boolean) {
        repositoriesListState.value = repositoriesListState.value?.copy(showLoading = isLoading)
    }

    private fun handleError(error: Throwable) {
        error.cause
    }

    private fun handleSuccess(list: List<GitRepositoryState>) {
        repositoriesListState.value?.let {
            repositoriesListState.value =
                it.copy(repositoriesList = list)
        }
    }
}
