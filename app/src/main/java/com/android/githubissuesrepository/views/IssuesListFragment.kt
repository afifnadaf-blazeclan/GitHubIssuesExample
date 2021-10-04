package com.android.githubissuesrepository.views

import android.databinding.BindingAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.android.githubissuesrepository.databinding.FragmentIssuesListBinding
import com.android.githubissuesrepository.utils.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by Afif Nadaf on 03/10/21.
 */
class IssuesListFragment : Fragment() {

    lateinit var mBinding : FragmentIssuesListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding =  FragmentIssuesListBinding.inflate(inflater, container, false)
        return  mBinding.root
    }


    companion object {

        @JvmStatic
        @BindingAdapter("profileImage")
        fun loadImage(view: ImageView, imageUrl: String?) {
            imageUrl?.let {
                Glide.with(view).load(it).circleCrop().into(view).apply { RequestOptions().centerCrop() }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun showRecyclerView() {
        mBinding.recyclerView.show()
        mBinding.progressBarLayout.hide()
    }


}