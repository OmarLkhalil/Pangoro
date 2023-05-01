package com.composable.pangoro.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.composable.pangoro.domain.Anime
import com.composable.pangoro.domain.repository.AnimeTrendingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AnimeViewModel  @Inject constructor (private val repo: AnimeTrendingRepository) :ViewModel() {

    private val _state = MutableStateFlow(AnimeState())
    val state = _state.asStateFlow()
    init {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            _state.update {
                it.copy(animes = repo.getTrendingAnime(), isLoading = false)
            }
        }
}
data class AnimeState(
        val isLoading: Boolean = true,
        val animes: List<Anime> = emptyList(),
        val error: String = ""
    )
}