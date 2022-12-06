package com.uranium.gitlist.main.presentation.repositorieslist

import androidx.lifecycle.Observer
import com.uranium.gitlist.main.domain.usecase.GetKotlinRepositoriesUseCase
import com.uranium.gitlist.main.presentation.repositorieslist.RepositoriesListViewModelTestStubs.gitListRepository
import com.uranium.gitlist.main.presentation.repositorieslist.RepositoriesListViewModelTestStubs.gitRepositoryState
import com.uranium.gitlist.main.setup.LocalTestRule
import com.uranium.gitlist.main.setup.TestCoroutineRule
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
internal class RepositoriesListViewModelTest {

    @get:Rule
    val localTestRule = LocalTestRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private val getKotlinRepositoriesUseCase: GetKotlinRepositoriesUseCase = mockk(relaxed = true)

    private val observerViewState = mockk<Observer<RepositoriesListState>>(relaxed = true)

    private lateinit var viewModel: RepositoriesListViewModel

    @Test
    fun `when RepositoriesListViewModel is created it should call getKotlinRepositoriesUseCase and when it returns successfully fill the state`() =
        runTest() {
            coEvery { getKotlinRepositoriesUseCase(1) } returns gitListRepository

            viewModel = createViewModel()
            viewModel.getUser().observeForever(observerViewState)

            coVerify {
                observerViewState.onChanged(RepositoriesListState().copy(repositoriesList = gitRepositoryState))
            }
        }

    private fun createViewModel() = RepositoriesListViewModel(
        getKotlinRepositoriesUseCase = getKotlinRepositoriesUseCase
    )
}
