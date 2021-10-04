package com.android.githubissuesrepository.localStorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.githubissuesrepository.models.IssuesModel

/**
 * Created by Afif Nadaf on 03/10/21.
 */
@Database(entities = [IssuesModel::class], version = 1, exportSchema = false)
abstract class GitHubDatabase : RoomDatabase(){

    companion object{
        const val DATABASE_NAME = "github_issues_db"
        const val TABLE_NAME = "github_issues"
    }

    abstract fun databaseDao() : GithubIssuesDao

}