package com.uranium.gitlist.main.data.repository

internal class ReadFile {
    operator fun invoke(path: String) = this.javaClass.classLoader?.getResource(path)?.readText()
}