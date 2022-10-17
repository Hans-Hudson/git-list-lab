package com.uranium.gitlist.main.presentation.repositorieslist

import com.uranium.gitlist.main.domain.model.GitRepository

internal class GitRepositoryMapper {
    fun mapToState(gitRepositoryList: List<GitRepository>): List<GitRepositoryState> =
        gitRepositoryList.map {
            GitRepositoryState(
                id = it.id,
                name = it.name,
                starsQtd = it.starsQtd.toString(),
                forkQtd = it.forkQtd.toString(),
                avatarUrl = it.avatarUrl,
                author = it.authorName,
                fullName = it.fullName,
                description = it.description,
                url = it.url,
            )
        }
}