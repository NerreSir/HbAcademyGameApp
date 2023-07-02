package com.example.hbacademyapp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hbacademyapp.ui.navBar.BottomNavigationBar
import com.example.hbacademyapp.ui.theme.HbBlue
import com.example.hbacademyapp.ui.theme.redHatDisplay
import com.example.hbjracademyapp.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(navController: NavController) {
    Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        Column {
            TopAppBar(
                title = {
                    androidx.compose.material3.Text(
                        fontFamily = redHatDisplay, //TODO çalışıyo mu bilemedim ya
                        text = "Favorite",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 20.sp,
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = HbBlue)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(id = R.color.teal_700))
                    .wrapContentSize(Alignment.Center)

            ) {
                Text(
                    text = "My Fav Screen",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp
                )
            }
        }
    }
}