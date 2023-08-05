package com.composable.pangoro.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.composable.pangoro.presentation.AnimeViewModel
import com.composable.pangoro.presentation.components.HomePager
import com.composable.pangoro.presentation.components.TopPager

@Composable
fun AnimeListScreen(
    state: AnimeViewModel.AnimeState,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TopPager(animeState = state)
        Spacer(modifier = Modifier.height(8.dp))
        HomePager(animeState = state)
    }
}
