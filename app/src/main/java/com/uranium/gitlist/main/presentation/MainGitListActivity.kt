package com.uranium.gitlist.main.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.uranium.gitlist.R
import com.uranium.gitlist.databinding.ActivityMainGitListBinding
import com.uranium.gitlist.main.presentation.repositorieslist.RepositoriesListFragment

internal class MainGitListActivity : AppCompatActivity(R.layout.activity_main_git_list) {

    lateinit var binding: ActivityMainGitListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainGitListBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main_git_list)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, RepositoriesListFragment.newInstance())
                .commit()
        }
    }
}