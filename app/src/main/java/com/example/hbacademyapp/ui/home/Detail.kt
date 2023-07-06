package com.example.hbacademyapp.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
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
    val image =
        rememberAsyncImagePainter(model = detailViewModel.gameDetail.collectAsState().value.backgroundImage)

    LaunchedEffect(gameId) {
        detailViewModel.getGameDetail(gameId)
    }

    Column {
        TopAppBar(
            title = { //Tittle
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
            }, //BackButton
            navigationIcon =
            {
                IconButton(modifier = Modifier,
                    onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            },  //Favorite button
            actions = {
                IconButton(
                    modifier = Modifier,
                    onClick = {
                        //TODO fav butonu
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Second Button",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = HbBlue)
        )


        Box() {
            //IMAGE
            Image(
                modifier = Modifier
                    .height(275.dp)
                    .fillMaxWidth()
                    .padding(top = 14.dp),
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            gameDetail.name?.let {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 16.dp),
                    fontFamily = redHatDisplay, //TODO çalışıyo mu bilemedim ya
                    text = it,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 20.sp,
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            //Desc header
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp),
                text = "Game Description",
                fontSize = 20.sp
            )
            //DESC
            gameDetail.description?.let {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(vertical = 16.dp),
                    text = it,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 4,
                    fontSize = 10.sp,
                    fontFamily = FontFamily.Serif
                )
            }

            Divider(color = Color.LightGray, thickness = 1.dp)

            //REDDİT
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .clickable { gameDetail.redditUrl }
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .padding(all = 16.dp),
            ) {
                Text(text = "Visit Reddit", fontSize = 15.sp)
            }

            Divider(color = Color.LightGray, thickness = 1.dp)

            //WEBSITE
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .clickable { gameDetail.website }
                    .wrapContentHeight(align = Alignment.CenterVertically)
                    .padding(all = 16.dp),
            ) {
                Text(text = "Visit Website", fontSize = 15.sp)
            }

            Divider(color = Color.LightGray, thickness = 1.dp)


        }
    }
}

//BORDER
//.border(BorderStroke(1.dp, Color.Green))


