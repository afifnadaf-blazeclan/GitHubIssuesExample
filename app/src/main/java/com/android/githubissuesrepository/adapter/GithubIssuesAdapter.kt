package com.android.githubissuesrepository.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.githubissuesrepository.BR
import com.android.githubissuesrepository.databinding.ListItemIssuesBinding
import com.android.githubissuesrepository.models.IssuesModel
import javax.inject.Inject

/**
 * Created by Afif Nadaf on 03/10/21.
 */
class GithubIssuesAdapter @Inject constructor() : RecyclerView.Adapter<GithubIssuesAdapter.IssuesViewHolder>() {

    private lateinit var items : List<IssuesModel>


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssuesViewHolder {
        val binding = ListItemIssuesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IssuesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IssuesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setAdapterData(issuesList : List<IssuesModel>){
        items = issuesList
    }

    class IssuesViewHolder(private val itemBinding : ListItemIssuesBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(issueData: IssuesModel){
            itemBinding.setVariable(BR.issueModel, issueData)
            itemBinding.executePendingBindings()
        }
    }
    override fun getItemCount() = items.size

}