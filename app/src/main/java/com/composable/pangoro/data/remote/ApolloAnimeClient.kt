package com.composable.pangoro.data.remote

import com.apollographql.apollo3.ApolloClient
import com.composable.pangoro.domain.Anime
import com.composable.pangoro.domain.repository.AnimeTrendingRepository
import com.plcoding.MediaQuery

class ApolloAnimeClient(private val apolloClient: ApolloClient): AnimeTrendingRepository {

    override suspend fun getTrendingAnime(): List<Anime> {
        val response = apolloClient.query(MediaQuery()).execute()
        return response.data?.let { data ->
            data.Page?.media?.mapNotNull { media ->
                media?.let {
                    Anime(
                        id = it.id,
                        title = it.title?.romaji.orEmpty(),
                        coverImageUrl = media.coverImage?.large.orEmpty()
                    )
                }
            }
        } ?: emptyList()
    }
}