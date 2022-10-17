package com.uranium.gitlist.main.data.repository

import com.uranium.gitlist.main.data.datasource.GitListRemoteDataSource
import com.uranium.gitlist.main.domain.model.GitQueryParams
import com.uranium.gitlist.main.domain.repository.GitListRepository

internal class GitListRepositoryImpl(private val gitListRemoteDataSource: GitListRemoteDataSource) :
    GitListRepository {
    override fun fetchRepositories(gitQueryParams: GitQueryParams) =
        gitListRemoteDataSource.fetchRepositories(gitQueryParams)
}