package com.uranium.gitlist.main.data.datasource

import com.uranium.gitlist.main.domain.model.GitQueryParams
import com.uranium.gitlist.main.domain.model.GitRepository
import kotlinx.coroutines.flow.Flow

internal interface GitListRemoteDataSource {
    fun fetchRepositories(filterParams: GitQueryParams): Flow<List<GitRepository>>
}