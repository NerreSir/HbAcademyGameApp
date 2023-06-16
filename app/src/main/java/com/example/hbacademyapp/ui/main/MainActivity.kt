package com.example.hbacademyapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.hbacademyapp.ui.home.DetailScreen
import com.example.hbacademyapp.ui.home.HomeScreen
import com.example.hbacademyapp.ui.theme.HbAcademyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HbAcademyAppTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController) }
                    composable(
                        "detail/{gameId}",
                        arguments = listOf(navArgument("gameId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val gameId = backStackEntry.arguments?.getInt("gameId")
                        gameId?.let { id ->
                            DetailScreen(navController, id)
                        }
                    }
                }
            }
        }
    }
}
