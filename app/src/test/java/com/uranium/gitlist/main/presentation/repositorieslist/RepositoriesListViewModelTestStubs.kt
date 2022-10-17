package com.uranium.gitlist.main.presentation.repositorieslist

import com.uranium.gitlist.main.domain.model.GitRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

internal object RepositoriesListViewModelTestStubs {

    val gitListRepository: Flow<List<GitRepository>> = flowOf(
        listOf(
            GitRepository(
                id = 1,
                name = "",
                starsQtd = 1,
                forkQtd = 1,
                avatarUrl = "",
                authorName = "",
                fullName = "",
                description = "",
                url = "",
            )
        )
    )

    val gitRepositoryState = listOf(
        GitRepositoryState(
            id = 1,
            name = "",
            starsQtd = "1",
            forkQtd = "1",
            avatarUrl = "",
            author = "",
            fullName = "",
            description = "",
            url = "",
        )
    )

}