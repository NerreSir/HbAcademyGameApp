package com.example.hbacademyapp.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.hbacademyapp.data.model.GameDetailModel
import com.example.hbacademyapp.ui.theme.HbBlue
import com.example.hbacademyapp.ui.theme.redHatDisplay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(gameDetail: GameDetailModel) {

    val image = rememberAsyncImagePainter(model = gameDetail.backgroundImage)


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

    }

    Column(
        modifier = Modifier
            .border(BorderStroke(1.dp, Color.Green))
            .height(275.dp)
            .width(375.dp)
    ) {
        //IMAGE
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }

    Column(
        modifier = Modifier
            .border(BorderStroke(1.dp, Color.Red))
            .height(142.dp)
            .width(375.dp)
    ) {
        //DESC
        gameDetail.name?.let { Text(text = it, fontWeight = FontWeight.Bold) }
    }

    Column(
        modifier = Modifier
            .border(BorderStroke(1.dp, Color.Blue))
            .height(54.dp)
            .width(375.dp)
            .clickable {
                gameDetail.redditUrl
            }
    ) {
        //REDDIT
        gameDetail.redditName?.let { Text(text = it, fontSize = 10.sp) }

    }

    Column(
        modifier = Modifier
            .border(BorderStroke(1.dp, Color.Black))
            .height(54.dp)
            .width(375.dp)
            .clickable {
                gameDetail.website
            }
    ) {
        //WEBSITE
        Text(text = "Visit Website", fontSize = 10.sp)

    }
}