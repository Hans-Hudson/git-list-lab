package com.uranium.gitlist.setup

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module

internal abstract class FragmentTestRule<F : Fragment> :
    ActivityTestRule<FragmentActivity>(FragmentActivity::class.java, true) {
    override fun afterActivityLaunched() {
        super.afterActivityLaunched()
        activity.runOnUiThread {
            val fm = activity.supportFragmentManager
            val transaction = fm.beginTransaction()
            transaction.replace(
                android.R.id.content,
                createFragment()
            ).commit()
        }
    }

    override fun beforeActivityLaunched() {
        super.beforeActivityLaunched()
        val application = InstrumentationRegistry.getInstrumentation()
            .targetContext.applicationContext as GitListTestApplication
        loadKoinModules(getModule())
    }

    protected abstract fun createFragment(): F

    protected abstract fun getModule(): Module

    fun launch() {
        launchActivity(Intent())
    }
}

internal fun <F : Fragment> createRule(fragment: F, module: Module): FragmentTestRule<F> =
    object : FragmentTestRule<F>() {
        override fun createFragment(): F = fragment
        override fun getModule(): Module = module
    }