@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hbacademyapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.hbacademyapp.data.model.GameModel
import com.example.hbacademyapp.ui.theme.HbBlue
import com.example.hbacademyapp.ui.theme.redHatDisplay

@Composable
fun HomeScreen() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val games = homeViewModel.games.collectAsState()

    Column {
        TopAppBar(
            title = {
                Text(
                    fontFamily = redHatDisplay, //TODO çalışıyo mu bilemedim ya
                    text = "GAMES",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = White,
                    fontSize = 20.sp,
                )
            },
            colors = topAppBarColors(containerColor = HbBlue)
        )

        LazyColumn {
            items(games.value) { game: GameModel ->
                GameCard(game = game)
            }
        }
    }
}

@Composable
fun GameCard(game: GameModel) {

    val image = rememberAsyncImagePainter(model = game.backgroundImage)

    Card(
        //elevation = 4.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
    ) {

        Row {

            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(120.dp)
                    .height(104.dp)
            )

            Column(modifier = Modifier.padding(10.dp)) {

                game.name?.let { Text(text = it, fontWeight = FontWeight.Bold) }

            }
        }
    }
}
