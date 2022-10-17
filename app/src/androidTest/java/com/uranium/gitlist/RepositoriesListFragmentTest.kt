package com.uranium.gitlist

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.uranium.gitlist.RepositoriesListFragmentStub.repositoriesList
import com.uranium.gitlist.main.domain.usecase.GetKotlinRepositoriesUseCase
import com.uranium.gitlist.main.presentation.repositorieslist.RepositoriesListFragment
import com.uranium.gitlist.main.presentation.repositorieslist.RepositoriesListViewHolder
import com.uranium.gitlist.main.presentation.repositorieslist.RepositoriesListViewModel
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

@RunWith(AndroidJUnit4::class)
@LargeTest
internal class RepositoriesListFragmentTest {

    private val getKotlinRepositoriesUseCase: GetKotlinRepositoriesUseCase = mockk(relaxed = true)

    @Before
    fun setup() {
        loadKoinModules(module {
            viewModel {
                RepositoriesListViewModel(
                    getKotlinRepositoriesUseCase = getKotlinRepositoriesUseCase
                )
            }
        })
    }

    @Test
    fun when_Start_Should_Assert_first_item_displayed() {
        every { getKotlinRepositoriesUseCase.invoke(1) } returns flowOf(
            repositoriesList
        )
        launchFragmentInContainer<RepositoriesListFragment>()

        onView(withText("okhttp")).check(matches(isDisplayed()))
        onView(withText("43013")).check(matches(isDisplayed()))
        onView(withText("8951")).check(matches(isDisplayed()))
        onView(withText("square")).check(matches(isDisplayed()))

    }

    @Test
    fun when_Start_Should_Assert_penultimate_item_is_displayed() {
        every { getKotlinRepositoriesUseCase.invoke(1) } returns flowOf(
            repositoriesList
        )
        launchFragmentInContainer<RepositoriesListFragment>()

        onView(withId(R.id.repositoriesList))
            .perform(RecyclerViewActions.scrollToPosition<RepositoriesListViewHolder>(9))

        onView(withText("iosched")).check(matches(isDisplayed()))
        onView(withText("21655")).check(matches(isDisplayed()))
        onView(withText("6280")).check(matches(isDisplayed()))
        onView(withText("google")).check(matches(isDisplayed()))
    }
}
