package com.example.hbacademyapp.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.hbacademyapp.ui.theme.HbBlue
import com.example.hbacademyapp.ui.theme.redHatDisplay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    navController: NavHostController,
    gameId: Int,
    detailViewModel: DetailViewModel = hiltViewModel()
) {

    val gameDetail = detailViewModel.gameDetail.collectAsState().value
    val image = rememberAsyncImagePainter(model = detailViewModel.gameDetail.collectAsState().value.backgroundImage)

    LaunchedEffect(gameId) {
        detailViewModel.getGameDetail(gameId)
    }

    Column {
        TopAppBar(
            title = {
                gameDetail.name?.let {
                    Text(
                        fontFamily = redHatDisplay, //TODO çalışıyo mu bilemedim ya
                        text = it,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = HbBlue)
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            //IMAGE
            Image(
                modifier = Modifier
                    .border(BorderStroke(1.dp, Color.Green))
                    .height(275.dp)
                    .fillMaxWidth(),
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )


                //DESC
                gameDetail.description?.let { Text(text = it, fontWeight = FontWeight.Bold, overflow = TextOverflow.Ellipsis, maxLines = 4) }



                //REDDIT
                gameDetail.redditName?.let { Text(modifier = Modifier.clickable { gameDetail.redditUrl }, text = it, fontSize = 10.sp) }



            Column(
                modifier = Modifier
                    .border(BorderStroke(1.dp, Color.Black))
                    .fillMaxWidth()
                    .clickable {
                        gameDetail.website
                    }
            ) {
                //WEBSITE
                Text(text = "Visit Website", fontSize = 10.sp)
            }
            Button(onClick = { navController.popBackStack() }) {
                
            }
        }
    }
}