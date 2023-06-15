package com.example.hbacademyapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.hbacademyapp.ui.home.HomeScreen
import com.example.hbacademyapp.ui.theme.HbAcademyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            HbAcademyAppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {

                    HomeScreen()

                }
            }
        }
    }
}

/*
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController)
{
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val games = homeViewModel.games.collectAsState()
    val gameDetail = homeViewModel.gameDetail.collectAsState()


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

        var text by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .border(BorderStroke(1.dp, Green))
                .height(75.dp)
            //.padding(top = 10.dp)
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
                            Icon(modifier = Modifier.clickable {
                                if (text.isNotEmpty()) {
                                    text = ""
                                } else {
                                    active = false
                                }
                            }, imageVector = Icons.Default.Close, contentDescription = "Close Icon")
                        }
                    }
                ) {
                }
            }
        }

        Column(
            modifier = Modifier
                .border(BorderStroke(1.dp, Red))
                .fillMaxSize()
                .padding(top = 1.dp)
        ) {
            LazyColumn {
                items(games.value) { game: GameModel ->
                    GameCard(game = game, viewModel = homeViewModel)
                }
            }
        }
    }
}

@Composable
fun GameCard(game: GameModel, viewModel: HomeViewModel) {

    val image = rememberAsyncImagePainter(model = game.backgroundImage)

    Card(
        //elevation = 4.dp,
        modifier = Modifier
            .height(136.dp)
            .padding(1.dp)
            .clickable {
                game.id?.let {
                    viewModel.getGameDetail(it)

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
*/

