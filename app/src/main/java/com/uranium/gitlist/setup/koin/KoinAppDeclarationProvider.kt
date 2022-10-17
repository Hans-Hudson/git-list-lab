package com.uranium.gitlist.setup.koin

import android.app.Application
import com.uranium.gitlist.main.di.MainGitListModule
import com.uranium.gitlist.setup.remote.RemoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.dsl.KoinAppDeclaration

object KoinAppDeclarationProvider {
    fun get(application: Application): KoinAppDeclaration = {
        androidLogger()
        androidContext(application)
        modules(
            listOf(
                MainGitListModule.getModule(),
                RemoteModule.remote
            )
        )
    }
}