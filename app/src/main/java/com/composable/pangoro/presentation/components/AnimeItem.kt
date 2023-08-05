package com.composable.pangoro.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.composable.pangoro.domain.Anime

@Composable
fun AnimeItem(
    anime: Anime,
    modifier: Modifier,
    contentScale: ContentScale,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .clickable { onClick() }
    ) {

        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(anime.coverImageUrl)
                .crossfade(true)
                .build(),
            contentDescription = anime.title,
            modifier = modifier,
            contentScale = contentScale,
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.2f))
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.7f))
                .height(90.dp)
                .align(Alignment.BottomStart),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = anime.title,
                modifier = Modifier
                    .padding(5.dp)
                    .align(Alignment.CenterVertically),
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}