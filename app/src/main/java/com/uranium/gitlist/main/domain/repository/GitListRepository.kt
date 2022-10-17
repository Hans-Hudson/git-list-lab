package com.uranium.gitlist.main.domain.repository

import com.uranium.gitlist.main.domain.model.GitQueryParams
import com.uranium.gitlist.main.domain.model.GitRepository
import kotlinx.coroutines.flow.Flow

internal interface GitListRepository {
    fun fetchRepositories(gitQueryParams: GitQueryParams): Flow<List<GitRepository>>
}