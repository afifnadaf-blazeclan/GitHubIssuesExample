package com.android.githubissuesrepository.repository

import android.content.Context
import com.android.githubissuesrepository.network.IssuesApiInterface
import com.android.githubissuesrepository.localStorage.GithubIssuesDao
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

/**
 * Created by Afif Nadaf on 03/10/21.
 */
@FragmentScoped
class GithubIssuesRepository @Inject constructor(
    githubIssuesDao: GithubIssuesDao,
    issuesApiInterface: IssuesApiInterface,
    context: Context
) {


}