package com.android.githubissuesrepository.models

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.githubissuesrepository.localStorage.GitHubDatabase
import com.google.gson.annotations.SerializedName

/**
 * Created by Afif Nadaf on 02/10/21.
 */
@Keep
@Entity(tableName = GitHubDatabase.TABLE_NAME)
data class IssuesModel(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "row_id") var row_id: Int,
    @SerializedName("url") var url : String,
    @SerializedName("html_url") var htmlUrl : String,
    @SerializedName("issue_url") var issueUrl : String,
    @SerializedName("id") var id : Int,
    @SerializedName("node_id") var nodeId : String,
    @SerializedName("user") var user : User,
    @SerializedName("created_at") var createdAt : String,
    @SerializedName("updated_at") var updatedAt : String,
    @SerializedName("author_association") var authorAssociation : String,
    @SerializedName("body") var body : String,
    @SerializedName("performed_via_github_app") var performedViaGithubApp : String,
    @SerializedName("title") var title : String

)
