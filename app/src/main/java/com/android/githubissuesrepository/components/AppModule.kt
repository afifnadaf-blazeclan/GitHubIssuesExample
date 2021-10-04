package com.android.githubissuesrepository.components

import android.content.Context
import androidx.room.Room
import com.android.githubissuesrepository.localStorage.GitHubDatabase
import com.android.githubissuesrepository.localStorage.GithubIssuesDao
import com.android.githubissuesrepository.network.IssuesApiInterface
import com.android.githubissuesrepository.repository.GithubIssuesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Afif Nadaf on 03/10/21.
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule(private val baseUrl : String) {

    @Singleton
    @Provides
    fun getLogging() : HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        return  httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun getOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor)
            = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()

    @Singleton
    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun getNewsDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, GitHubDatabase::class.java,
        GitHubDatabase.DATABASE_NAME
    ).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun getApiInterface(retrofit: Retrofit): IssuesApiInterface =
        retrofit.create(IssuesApiInterface::class.java)

    @Singleton
    @Provides
    fun getDatabaseDao(database: GitHubDatabase) = database.databaseDao()


    @Singleton
    @Provides
    fun getIssuesRepository(issuesApiInterface: IssuesApiInterface, githubIssuesDao: GithubIssuesDao, @ApplicationContext context: Context)
            = GithubIssuesRepository(githubIssuesDao, issuesApiInterface, context)

}