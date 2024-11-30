package com.example.cryptofor.ui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cryptofor.ui.ui.home.HomeScreen
import com.example.cryptofor.ui.ui.signIn.SignInScreen


@Composable
fun NavigationGraph(
    modifier: Modifier,
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = "HomeScreen",
        modifier = modifier
    ){
        composable("SignInScreen"){
            SignInScreen(navController , modifier)
        }
        composable("HomeScreen"){
            HomeScreen(navController , modifier)
        }
    }
}

