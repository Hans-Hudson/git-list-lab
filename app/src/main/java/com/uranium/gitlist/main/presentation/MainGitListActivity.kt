package com.uranium.gitlist.main.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.uranium.gitlist.R
import com.uranium.gitlist.databinding.ActivityMainGitListBinding
import com.uranium.gitlist.main.presentation.repositorieslist.RepositoriesListFragment

internal class MainGitListActivity : AppCompatActivity(R.layout.activity_main_git_list) {

    private val binding: ActivityMainGitListBinding by lazy {
        ActivityMainGitListBinding.bind(findViewById(R.id.mainGitListRoot))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.container.id, RepositoriesListFragment.newInstance())
                .commit()
        }
    }
}