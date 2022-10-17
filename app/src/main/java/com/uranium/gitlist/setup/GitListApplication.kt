package com.uranium.gitlist.setup

import android.app.Application
import com.uranium.gitlist.setup.koin.KoinAppDeclarationProvider
import org.koin.core.context.startKoin

internal class GitListApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }
    private fun setupKoin() {
        startKoin(appDeclaration = KoinAppDeclarationProvider.get(this))
    }
}