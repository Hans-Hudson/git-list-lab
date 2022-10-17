package com.uranium.gitlist.main.presentation.repositorieslist

internal data class RepositoriesListState(
    val showLoading: Boolean = false,
    val repositoriesList: List<GitRepositoryState>? = null,
    val pageIndex: Int = 0,
)

internal data class GitRepositoryState(
    val id: Int,
    val name: String?,
    val starsQtd: String?,
    val forkQtd: String?,
    val avatarUrl: String?,
    val author: String?,
    val fullName: String,
    val description: String?,
    val url: String,
)