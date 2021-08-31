package com.example.tvshowmanager.data.impl

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.coroutines.await
import com.example.tvshowmanager.LoginMutation
import com.example.tvshowmanager.data.remote.contract.MovieRemoteRepository
import java.util.*
import javax.inject.Inject

class MovieRemoteRepositoryImpl @Inject constructor(
    private val apolloClient: ApolloClient
) : MovieRemoteRepository {

    override suspend fun createMovie(title: String, releaseDate: Date, seasons: Float) {
        return try {
            val response =
                apolloClient.mutate(LoginMutation(email = Input.fromNullable(""))).await()

        } catch (e: Exception) {

        }
    }
}