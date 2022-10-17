package com.uranium.gitlist.main.di

import com.uranium.gitlist.main.data.api.GitListService
import com.uranium.gitlist.main.data.datasource.GitListRemoteDataSourceImpl
import com.uranium.gitlist.main.data.repository.GitListRepositoryImpl
import com.uranium.gitlist.main.domain.usecase.GetKotlinRepositoriesUseCase
import com.uranium.gitlist.main.presentation.repositorieslist.RepositoriesListViewModel
import com.uranium.gitlist.setup.remote.HttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal object MainGitListModule {
    fun getModule() = module {
        factory { get<HttpClient>().create(GitListService::class.java) }
        factory {
            GetKotlinRepositoriesUseCase(
                gitListRepository = GitListRepositoryImpl(
                    gitListRemoteDataSource = GitListRemoteDataSourceImpl(
                        service = get()
                    )
                )
            )
        }
        viewModel {
            RepositoriesListViewModel(
                getKotlinRepositoriesUseCase = get()
            )
        }
    }
}