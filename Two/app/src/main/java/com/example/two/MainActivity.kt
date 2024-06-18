package com.example.two

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.two.ui.theme.TwoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TwoTheme {
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
    Column{
        Image(
            painter = painterResource(R.drawable.bg_compose_background),
            contentDescription = null,
        )
        GreetingText(Modifier)
    }

}

@Composable
fun GreetingText(modifier: Modifier = Modifier){
    val h1 = stringResource(R.string.h1)
    val intro1 = stringResource(R.string.Intro1)
    val intro2 = stringResource(R.string.Intro2)

    Column{
        Text(
            text = h1,
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp),

        )
        Text(
            text = intro1,
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = intro2,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(16.dp)

        )
}

}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    TwoTheme {
        Greeting()

    }
}