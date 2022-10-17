package com.uranium.gitlist.main.data.mapper

import com.uranium.gitlist.main.data.model.GitRepositoryResponse
import com.uranium.gitlist.main.domain.model.GitRepository

internal class GitRepositoryResponseMapper {
    fun map(source: List<GitRepositoryResponse>): List<GitRepository> {
        return source.mapNotNull {
            if (it.id == null && it.fullName == null && it.htmlUrl == null) null
            else {
                GitRepository(
                    id = it.id!!,
                    name = it.name,
                    starsQtd = it.stargazersCount,
                    forkQtd = it.forksCount,
                    avatarUrl = it.owner?.avatarUrl,
                    authorName = it.owner?.login,
                    fullName = it.fullName!!,
                    description = it.description,
                    url = it.htmlUrl!!,
                )
            }
        }
    }
}