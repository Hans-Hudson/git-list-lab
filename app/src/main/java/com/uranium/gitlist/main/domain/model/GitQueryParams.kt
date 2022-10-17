package com.uranium.gitlist.main.domain.model

internal data class GitQueryParams(
    val query: String = "language:kotlin",
    val sort: String = "stars",
    val order: String = "desc",
    val perPage: Int = 10,
    val page: Int = 0
)