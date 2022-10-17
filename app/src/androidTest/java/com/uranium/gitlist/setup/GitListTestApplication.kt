package com.uranium.gitlist.setup

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

internal class GitListTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(KoinTestAppDeclarationProvider.get(this))
    }

}

private object KoinTestAppDeclarationProvider {
    fun get(application: Application): KoinAppDeclaration = {
        androidContext(application)
        modules(
            emptyList()
        )
    }
}