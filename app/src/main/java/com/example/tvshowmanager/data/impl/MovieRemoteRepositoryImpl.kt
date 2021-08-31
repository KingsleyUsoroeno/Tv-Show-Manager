package com.example.tvshowmanager.data.impl

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import com.apollographql.apollo.coroutines.await
import com.example.tvshowmanager.CreateMovieMutation
import com.example.tvshowmanager.data.remote.contract.MovieRemoteRepository
import java.util.*
import javax.inject.Inject

class MovieRemoteRepositoryImpl @Inject constructor(
    private val apolloClient: ApolloClient
) : MovieRemoteRepository {

    override suspend fun createMovie(
        title: String, releaseDate: Date,
        seasons: Double
    ): CreateMovieMutation.Movie? {
        return apolloClient.mutate(
            CreateMovieMutation(
                title = title,
                releaseDate = Input.fromNullable(releaseDate),
                seasons = seasons
            )
        ).await().data?.createMovie?.movie
    }
}