package com.android.githubissuesrepository.network

import com.android.githubissuesrepository.models.IssuesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Afif Nadaf on 03/10/21.
 */
interface IssuesApiInterface {

    @GET("/issues")
    fun getGithubIssues(): List<IssuesModel>
}