package com.android.githubissuesrepository.localStorage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.android.githubissuesrepository.models.IssuesModel

/**
 * Created by Afif Nadaf on 03/10/21.
 */
@Dao
interface GithubIssuesDao {

    @Query("SELECT * FROM ${GitHubDatabase.TABLE_NAME}")
    fun getIssues() : List<IssuesModel>

    @Insert
    fun insertIssue(issuesModel: IssuesModel)

    @Query("DELETE FROM ${GitHubDatabase.TABLE_NAME}")
    fun deleteAllRecords()

    @Query("SELECT * FROM ${GitHubDatabase.TABLE_NAME} WHERE row_id = :rowId")
    fun getIssueComments(rowId: Int) : IssuesModel

}