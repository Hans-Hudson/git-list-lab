package com.uranium.gitlist.main.presentation.repositorieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.uranium.gitlist.R
import com.uranium.gitlist.databinding.ItemInvoiceRepositoryBinding

internal class RepositoriesListAdapter(private val repositoryListener: RepositoryListener) :
    RecyclerView.Adapter<RepositoriesListViewHolder>() {

    private var currentList = mutableListOf<GitRepositoryState>()
    private var lastList = mutableListOf<GitRepositoryState>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoriesListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_invoice_repository, parent, false)

        return RepositoriesListViewHolder(view, repositoryListener)
    }

    override fun onBindViewHolder(holder: RepositoriesListViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.count()
    }

    fun updateList(list: List<GitRepositoryState>) {
        if (lastList != list) {
            lastList.clear()
            lastList = list.toMutableList()
            val currentLastIndex = currentList.lastIndex
            currentList.addAll(lastList)
            notifyItemRangeInserted(currentLastIndex + 1, lastList.size)

        }
    }
}

internal class RepositoriesListViewHolder(
    itemView: View,
    val repositoryListener: RepositoryListener
) :
    RecyclerView.ViewHolder(itemView) {

    private val binding = ItemInvoiceRepositoryBinding.bind(itemView)

    fun bind(gitRepositoryState: GitRepositoryState) {
        with(gitRepositoryState) {
            setupAvatarImage()
            binding.name.text = name
            binding.starsQtd.text = starsQtd
            binding.forkQtd.text = forkQtd
            binding.author.text = author
        }
        itemView.setOnClickListener {
            repositoryListener(gitRepositoryState.id)
        }
    }

    private fun GitRepositoryState.setupAvatarImage() {
        Glide.with(itemView.context).load(avatarUrl).diskCacheStrategy(
            DiskCacheStrategy.AUTOMATIC
        ).into(binding.avatar)
    }
}