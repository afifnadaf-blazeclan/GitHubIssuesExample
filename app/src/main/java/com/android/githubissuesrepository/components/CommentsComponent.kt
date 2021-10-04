package com.android.githubissuesrepository.components

import android.content.Context
import com.android.githubissuesrepository.views.IssueCommentsListFragment
import dagger.BindsInstance
import dagger.Component

/**
 * Created by Afif Nadaf on 03/10/21.
 */
@Component(dependencies = [AppModule::class])
interface CommentsComponent {

    fun inject(issueCommentsListFragment: IssueCommentsListFragment)

    @Component.Builder
    interface Builder{
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(appModule: AppModule): Builder
        fun build(): CommentsComponent
    }

}