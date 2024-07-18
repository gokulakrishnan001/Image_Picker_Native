package com.example.taskui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.taskui.ui.theme.Orange


@Composable
fun LoginScreen(
 navController: NavController
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        val context= LocalContext.current
        Image(painter = painterResource(id = R.drawable.img_1), contentDescription = "",
            modifier = Modifier.padding(top=10.dp)
            )
        Image(painter = painterResource(id = R.drawable.img), contentDescription = "")
        Text(text = "Biomedical Kisok",
            fontSize = 15.sp,
            fontWeight = FontWeight.W400
            )
        Text("                                              for HCE's",
            fontSize = 10.sp,
            color = Orange,
            modifier = Modifier.align(Alignment.CenterHorizontally)

            )
        OutlinedTextField(value = username, onValueChange ={
                 username=it
        } ,
            placeholder = {
                          Text("Username")
            },

            modifier = Modifier.padding(10.dp),

            colors = TextFieldDefaults.colors(
                disabledContainerColor = Color.White,
                focusedContainerColor = Color.White,
                disabledPlaceholderColor = Color.Black,
                focusedTextColor = Color.Black,
                unfocusedContainerColor = Color.White,
                unfocusedTextColor = Color.Black,
            )
            )
        OutlinedTextField(value = password, onValueChange ={
            password=it
        },
            placeholder = {
                Text("Password")
            },
           colors = TextFieldDefaults.colors(
               disabledContainerColor = Color.White,
               focusedContainerColor = Color.White,
               disabledPlaceholderColor = Color.Black,
               focusedTextColor = Color.Black,
               unfocusedContainerColor = Color.White,
               unfocusedTextColor = Color.Black,
           ),
            visualTransformation = PasswordVisualTransformation()
            )

        Button(onClick = {
            if(username.isNotEmpty() && password.isNotEmpty()){
                navController.navigate("image_screen")
            }else{
                Toast.makeText(context,"Please Enter All Fields",Toast.LENGTH_LONG).show()
            }
        },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(top = 10.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Orange
            ),
            shape = RoundedCornerShape(15),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 10.dp,
                disabledElevation = 13.dp
            ),

         
        ) {
            Text("Login",
                fontSize = 15.sp,
                color = Color.White
                )
        }

      ContactArea()
      TradeMark()
    }
}

@Composable
fun ContactArea(){
    Spacer(modifier = Modifier.height(25.dp))
    Text(" For Assistance & Login Details Contact",
        fontSize = 13.sp
        )
    TextArea(text1 = "English, Kannada, Telugu :", text2 ="7406333800")
    TextArea(text1 = "English, Kannada, Hindi :", text2 = "9071386515")
}

@Composable
fun TextArea(
    text1:String,
    text2:String
){
    Row {
        Text(text1,
            fontSize = 13.sp
            )
        Text(
            modifier = Modifier.drawBehind {
                val strokeWidthPx = 1.dp.toPx()
                val verticalOffset = size.height - 2.sp.toPx()
                drawLine(
                    color = Orange,
                    strokeWidth = strokeWidthPx,
                    start = Offset(0f, verticalOffset),
                    end = Offset(size.width, verticalOffset)
                )
            },
            text = text2,
            color =  Orange
        )

    }
}


@Composable
fun TradeMark(){
    Spacer(modifier = Modifier.height(120.dp))
    Text("v1.7 \u00a9 Codeland InfoSolutions Pvt Ltd.",
        modifier = Modifier.padding(start = 4.dp),
        fontSize = 12.sp
        )

}