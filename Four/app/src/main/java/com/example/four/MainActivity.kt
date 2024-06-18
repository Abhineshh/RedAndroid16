package com.example.four

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.four.ui.theme.FourTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FourTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting( modifier: Modifier = Modifier) {

        Column(
            modifier = modifier.fillMaxSize()
        ){
            Row(
                modifier = modifier
                    .height(430.dp)
                    .width(430.dp)
                    .fillMaxHeight()
                    .fillMaxWidth()
            ){
                GreetingBox(stringResource(R.string.h1_1), stringResource(R.string.para1), Color(0xFFEADDFF))
                GreetingBox(h1 = stringResource(R.string.h1_2) , para = stringResource(R.string.para2),Color(0xFFD0BCFF) )
            }
            Row(
                modifier = modifier
                    .height(430.dp)
                    .width(400.dp)
                    .fillMaxHeight()
                    .fillMaxWidth()
            ){
                GreetingBox(h1 = stringResource(R.string.h1_3), para = stringResource(R.string.para3 ),Color(0xFFD0BCFF))
                GreetingBox(h1 = stringResource(R.string.h1_4), para = stringResource(R.string.para4 ), Color(0xFFEADDFF))
            }
        }
    }

@Composable
fun GreetingBox(h1: String, para: String, colors: Color, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .width(200.dp)
            .height(430.dp)
            .background(colors)
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = h1,
            fontWeight = FontWeight(1000)
        )
        Text(
            text = para,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(top = 16.dp)
        )
    }
}




@Preview(showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    FourTheme {
        Greeting()
    }
}