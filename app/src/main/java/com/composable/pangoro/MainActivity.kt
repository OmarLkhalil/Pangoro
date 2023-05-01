package com.composable.pangoro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.composable.pangoro.presentation.AnimeListScreen
import com.composable.pangoro.presentation.AnimeViewModel
import com.composable.pangoro.ui.theme.PangoroTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PangoroTheme {
                val viewModel: AnimeViewModel = hiltViewModel()
                val state by viewModel.state.collectAsState()
                AnimeListScreen(state)
            }
        }
    }
}
