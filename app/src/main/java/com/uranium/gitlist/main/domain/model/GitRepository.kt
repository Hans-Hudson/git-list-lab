package com.uranium.gitlist.main.domain.model

internal data class GitRepository(
    val id: Int,
    val name: String?,
    val starsQtd: Int?,
    val forkQtd: Int?,
    val avatarUrl: String?,
    val authorName: String?,
    val fullName: String,
    val description: String?,
    val url: String,
)