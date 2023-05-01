package com.composable.pangoro.di

import com.apollographql.apollo3.ApolloClient
import com.composable.pangoro.data.remote.ApolloAnimeClient
import com.composable.pangoro.domain.repository.AnimeTrendingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://graphql.anilist.co")
            .build()
    }

    @Provides
    @Singleton
    fun provideAnimeClient(apolloClient: ApolloClient): ApolloAnimeClient {
        return ApolloAnimeClient(apolloClient)
    }

    @Provides
    fun provideRepo(animeClient: ApolloAnimeClient): AnimeTrendingRepository {
        return animeClient
    }
}