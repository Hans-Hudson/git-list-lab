package com.uranium.gitlist.main.domain.usecase

import com.uranium.gitlist.main.domain.model.GitQueryParams
import com.uranium.gitlist.main.domain.repository.GitListRepository

internal class GetKotlinRepositoriesUseCase(private val gitListRepository: GitListRepository) {
    operator fun invoke(currentPage: Int) =
        gitListRepository.fetchRepositories(GitQueryParams().copy(page = currentPage))
}