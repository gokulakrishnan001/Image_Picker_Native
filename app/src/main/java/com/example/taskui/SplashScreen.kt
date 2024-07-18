package com.example.taskui

import android.window.SplashScreen
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.taskui.ui.theme.Orange
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
){
    LaunchedEffect(key1 = true) {
      delay(2000L)
        navController.navigate("login_screen")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Orange),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SplashScreenData()
    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenData(

){



   Card(
   shape = RoundedCornerShape(30),
       elevation = CardDefaults.cardElevation(
           defaultElevation = 8.dp,

       ),
       border = BorderStroke(
           width = 0.5.dp,
           brush = Brush.radialGradient(
               colors = listOf<Color>(Orange, Color.White)
           )
       ),
    modifier = Modifier.padding(16.dp),

       colors = CardDefaults.cardColors(
           containerColor = Color.White
       )



       ){
       Column(

       ) {
           Image(
               painter = painterResource(id = R.drawable.img),
               contentDescription = "",
               modifier = Modifier
                   .padding(top = 20.dp, end = 10.dp)
                   .align(Alignment.CenterHorizontally)
           )

           Image(
               painter = painterResource(id = R.drawable.img_1),
               contentDescription = "",
               modifier = Modifier
                   .align(Alignment.CenterHorizontally)
               )

       }

   }

}
