package com.cikyra.hometeam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cikyra.hometeam.compose.nav.AppRoutes
import com.cikyra.hometeam.theme.HomeTeamTheme
import com.cikyra.hometeam.compose.features.home.HomeScreen
import com.cikyra.hometeam.compose.features.splash.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
        
            HomeTeamTheme {                                   
                Scaffold(modifier= Modifier.fillMaxSize()) { innerPadding ->

                    NavHost(
                        navController = navController,
                        startDestination = AppRoutes.SplashScreen,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<AppRoutes.SplashScreen> {
                            SplashScreen(
                                onLetsGoClicked = { id ->
                                    navController.navigate(AppRoutes.HomeScreen(id))
                                }
                            )
                        }
                        composable<AppRoutes.HomeScreen> {
                            HomeScreen()
                        }                   
                    }
                }
            }
        }
    }
}