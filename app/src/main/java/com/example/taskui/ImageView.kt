package com.example.taskui

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.taskui.ui.theme.Orange
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@Composable
fun ImageUploadView(
    navController: NavController
){


        ImageView(navController)

}


@Composable
fun ImageView(
 navController: NavController
){
    val stroke = Stroke(width = 2f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
    )
    var selectedItemUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val photoPicker= rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ){
        selectedItemUri=it
    }
    val context= LocalContext.current
    Text("Upload a Image",
        modifier = Modifier.padding(top = 30.dp)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f)
            .padding(top = 30.dp, end = 20.dp, start = 20.dp, bottom = 90.dp)
            .drawBehind {
                drawRoundRect(color = Color.Black, style = stroke)
            },
        contentAlignment = Alignment.Center
    ){


        AsyncImage(model = selectedItemUri ?: R.drawable.img_2,
            contentDescription = "")

    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {
            photoPicker.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange
            ),
            shape = RoundedCornerShape(30),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 10.dp,
                disabledElevation = 10.dp
            ),
      modifier = Modifier.size(width = 145.dp, height = 40.dp)
        ) {
            Text("Upload",
                color = Color.White
                )
        }
        Button(onClick = {
            val encodedUrl = URLEncoder.encode(selectedItemUri.toString(), StandardCharsets.UTF_8.toString())

            if(selectedItemUri!=null) {
                             navController.navigate("image_preview/$encodedUrl")
                         }else{
                             Toast.makeText(context,"Image not Selected",Toast.LENGTH_LONG).show()
                         }
                         },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray
            ),
            shape = RoundedCornerShape(30),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 10.dp,
                disabledElevation = 10.dp
            ),
            modifier = Modifier.size(width = 145.dp, height = 40.dp)
            ) {
            Text("View",
                color = Color.Black
                )
        }
    }

}


@Composable
fun Preview(
    imageUri:Uri
){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        AsyncImage(model = imageUri, contentDescription = "")
    }
}
