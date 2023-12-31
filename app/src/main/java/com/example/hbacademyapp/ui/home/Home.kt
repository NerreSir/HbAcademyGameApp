@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hbacademyapp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.hbacademyapp.data.model.GameModel
import com.example.hbacademyapp.ui.theme.HbBlue
import com.example.hbacademyapp.ui.theme.redHatDisplay
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import com.example.hbacademyapp.ui.navBar.BottomNavigationBar


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()) {
    val games = homeViewModel.games.collectAsState()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        Column {
            TopAppBar(
                title = {
                    Text(
                        fontFamily = redHatDisplay,
                        text = "Games",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = White,
                        fontSize = 20.sp,
                    )
                },
                colors = topAppBarColors(containerColor = HbBlue)
            )

            var text by remember { mutableStateOf("") }
            var active by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier
                    .border(BorderStroke(1.dp, Green))
                    .height(75.dp)
            ) {
                Scaffold {
                    SearchBar(
                        modifier = Modifier
                            .fillMaxWidth(),
                        query = text,
                        onQueryChange = { text = it },
                        onSearch = { active = false },
                        active = active,
                        onActiveChange = { active = it },
                        placeholder = { Text(text = "Search for Games") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search Icon"
                            )
                        },
                        trailingIcon = {
                            if (active) {
                                Icon(
                                    modifier = Modifier.clickable {
                                        if (text.isNotEmpty()) {
                                            text = ""
                                        } else {
                                            active = false
                                        }
                                    },
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close Icon"
                                )
                            }
                        }
                    ) {
                    }
                }
            }

            Column(
                modifier = Modifier
                    .border(BorderStroke(3.dp, Red))
                    .fillMaxSize()
                    .padding(top = 1.dp)
                    .padding(bottom = 70.dp)
            ) {
                LazyColumn {
                    items(games.value) { game: GameModel ->
                        GameCard(game = game, navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun GameCard(game: GameModel, navController: NavController) {

    val image = rememberAsyncImagePainter(model = game.backgroundImage)

    Card(
        //elevation = 4.dp,
        modifier = Modifier
            .height(136.dp)
            .padding(1.dp)
            .clickable {
                game.id?.let { gameId ->
                    navController.navigate("detail/$gameId")
                }
            },
        shape = RoundedCornerShape(5.dp),
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(120.dp)
                    .fillMaxHeight()
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp), verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    game.name?.let { Text(text = it, fontWeight = FontWeight.Bold) }
                }

                Column(modifier = Modifier.fillMaxWidth()) {
                    game.metacritic?.let { Text(text = "Metacritic: $it") }
                    Text(text = "Action, shooter", fontSize = 10.sp)
                }
            }
        }
    }
}


//.border(BorderStroke(1.dp, Red))

//DEPO
//Burda işlemi aslında otomatize yapmış çok daha mantıklı ama navigasyon yönlendirmesinin
//daha zor olduğunu düşündüğüm için kullanmayacağım gibi
/*
items.forEach { item ->
                BottomNavigationItem(modifier = Modifier.border(BorderStroke(1.dp, Blue)),
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(imageVector = item.icon, contentDescription = "Icon")
                            Text(item.title)
                        }
                    },
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            launchSingleTop = true
                        }
                    }
                )
            }
 */
