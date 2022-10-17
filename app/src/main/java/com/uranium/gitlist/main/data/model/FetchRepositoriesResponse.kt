package com.uranium.gitlist.main.data.model

import com.google.gson.annotations.SerializedName

internal data  class FetchRepositoriesResponse (
    @SerializedName("items")
    val repositoriesListResponse: List<GitRepositoryResponse>
)