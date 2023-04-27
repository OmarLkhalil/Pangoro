package com.composable.pangoro.domain.repository

import com.composable.pangoro.domain.Anime

interface AnimeTrendingRepository {
    suspend fun getTrendingAnime(): List<Anime>
}