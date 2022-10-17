package com.uranium.gitlist.main.data.datasource

import com.uranium.gitlist.main.data.api.GitListService
import com.uranium.gitlist.main.data.mapper.GitRepositoryResponseMapper
import com.uranium.gitlist.main.domain.model.GitQueryParams
import com.uranium.gitlist.main.domain.model.GitRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

internal class GitListRemoteDataSourceImpl(
    private val service: GitListService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) :
    GitListRemoteDataSource {
    override fun fetchRepositories(filterParams: GitQueryParams): Flow<List<GitRepository>> = flow {
        emit(
            service.fetchRepositories(
                filterParams.query,
                filterParams.sort,
                filterParams.order,
                filterParams.perPage,
                filterParams.page,
            ).let {
                GitRepositoryResponseMapper().map(it.repositoriesListResponse)
            })
    }.flowOn(dispatcher)
}
