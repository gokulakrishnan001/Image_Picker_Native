package com.example.taskui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        // Main Screen
        composable("login_screen") {
            LoginScreen(navController)
        }
        composable("image_screen") {
           Column(
               verticalArrangement = Arrangement.Top,
               horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier.fillMaxSize()
           ) {
               ImageView(navController)
           }

        }

       composable(route = "image_preview/{imageUri}",
           arguments = listOf(
               navArgument("imageUri"){
                   type= NavType.StringType
               }
           )
           ){
           val uri=it.arguments?.getString("imageUri")
           val context= LocalContext.current
           Column(
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               if (uri != null) {
                   Preview(imageUri = uri.toUri())
               }else{
                   Toast.makeText(context,"Image not Supported",Toast.LENGTH_LONG).show()
               }
           }
       }

    }
}