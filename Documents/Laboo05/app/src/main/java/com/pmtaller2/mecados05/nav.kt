package com.pmtaller2.mecados05

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun navLo(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home"){
        composable("home") {
            MaybeHome(navController = navController)
        }
        composable("screenA") {
            ScreenA(navController = navController)

        }
        composable("screenB") {
            ScreenB(navController = navController)
        }
    }
}

@Composable
fun MaybeHome(navController: NavController){
    HomeView(navController = navController)
}

@Composable
fun ScreenA(navController: NavController) {
    MainView()
}

@Composable
fun ScreenB(navController: NavController){
    GyroscopeSensor()
}
