package com.composable.pangoro.presentation

import com.composable.pangoro.domain.Anime
import com.composable.pangoro.domain.repository.AnimeTrendingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AnimeViewModel  @Inject constructor (private val repo: AnimeTrendingRepository) {

    suspend fun  getAnimeTrending(): List<Anime> {
        val trendingAnime = repo.getTrendingAnime()
        return trendingAnime
    }

}