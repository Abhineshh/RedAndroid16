package com.example.five

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.five.ui.theme.FiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FiveTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Greeting(name = "kaido")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
   Column (
       modifier = modifier.fillMaxWidth()
           .fillMaxHeight()
           .background(Color(R.color.teal_700))
   ){
       Box(
           modifier = modifier.height(400.dp)
               .fillMaxWidth(),
       ) {
           Column(
               modifier = modifier.fillMaxSize(),
               verticalArrangement = Arrangement.Bottom,
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               Image(
                   painter = painterResource(R.drawable.android_logo),
                   contentDescription = null,
                   modifier = modifier
                       .height(100.dp)
                       .background(Color(R.color.black))
               )
               Text(
                   text = name,
                   fontSize = 50.sp
               )
               Text(
                   text = "Android Developer Extraordinaire",
                   color = Color.Green
               )
           }
       }
       Column(
           modifier = modifier.fillMaxWidth()
               .fillMaxHeight(),
           verticalArrangement =  Arrangement.Bottom,
           horizontalAlignment = Alignment.CenterHorizontally
       ){
            Contact("+123456789",Modifier)
           Contact("@AndroidDev",Modifier)
           Contact("android.dev@earth.com",Modifier)
       }
   }
}

@Composable
fun Contact(contacter : String,modifier: Modifier = Modifier){
    Row (
        modifier = modifier.height(50.dp)
            .width(250.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Icon(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = modifier.height(35.dp)
                .width(35.dp)
        )
        Text(
            text = contacter,
            modifier = modifier.fillMaxSize()
                .align(Alignment.CenterVertically)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    FiveTheme {
        Greeting("Android")
    }
}