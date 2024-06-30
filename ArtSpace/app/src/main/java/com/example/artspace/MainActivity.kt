package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var currentImage by remember { mutableStateOf(1) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            ArtSpacePicture(currentImage = currentImage)
            Spacer(modifier = Modifier.height(30.dp))
            PictureInfo(modifier, currentImage = currentImage)
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = {
                    if (currentImage > 1) currentImage -= 1
                }, modifier = Modifier.width(150.dp)) {
                    Text(text = stringResource(R.string.button_1))
                }
                Button(onClick = {
                    currentImage = (currentImage % 9) + 1
                }, modifier = Modifier.width(150.dp)) {
                    Text(text = stringResource(R.string.button_2))
                }
            }
        }
    }
}

@Composable
fun ArtSpacePicture(
    modifier: Modifier = Modifier,
    currentImage: Int = 0
) {
    val currentResource = when (currentImage) {
        1 -> painterResource(R.drawable.wallpaper__24_)
        2 -> painterResource(R.drawable.wallpaper__10_)
        3 -> painterResource(R.drawable.wallpaper__5_)
        4 -> painterResource(R.drawable.wallpaper__2_)
        5 -> painterResource(R.drawable.wallpaper__6_)
        6 -> painterResource(R.drawable.wallpaper__4_)
        7 -> painterResource(R.drawable.wallpaper__13_)
        8 -> painterResource(R.drawable.wallpaper__11_)
        else -> painterResource(R.drawable.wallpaper__22_)
    }
    Card(
        modifier = Modifier
    ) {
        Image(
            painter = currentResource,
            contentDescription = null,
            modifier = modifier
                .height(500.dp)
                .width(300.dp)
                .background(Color.White)
                .padding(25.dp)

        )
    }
}

@Composable
fun PictureInfo(
    modifier: Modifier = Modifier,
    currentImage: Int
) {
    val currentResource = when (currentImage) {
        1 -> stringResource(R.string.picture_1)
        2 -> stringResource(R.string.picture_2)
        3 -> stringResource(R.string.picture_3)
        4 -> stringResource(R.string.picture_4)
        5 -> stringResource(R.string.picture_5)
        6 -> stringResource(R.string.picture_6)
        7 -> stringResource(R.string.picture_7)
        8 -> stringResource(R.string.picture_8)
        else -> stringResource(R.string.picture_9)
    }
    val currentResource2 = when (currentImage) {
        1 -> stringResource(R.string.artist_1)
        2 -> stringResource(R.string.artist_2)
        3 -> stringResource(R.string.artist_3)
        4 -> stringResource(R.string.artist_4)
        5 -> stringResource(R.string.artist_5)
        6 -> stringResource(R.string.artist_6)
        7 -> stringResource(R.string.artist_7)
        8 -> stringResource(R.string.artist_8)
        else -> stringResource(R.string.artist_9)
    }
    val currentResource3 = when (currentImage) {
        1 -> stringResource(R.string.year_1)
        2 -> stringResource(R.string.year_2)
        3 -> stringResource(R.string.year_3)
        4 -> stringResource(R.string.year_4)
        5 -> stringResource(R.string.year_5)
        6 -> stringResource(R.string.year_6)
        7 -> stringResource(R.string.year_7)
        8 -> stringResource(R.string.year_8)
        else -> stringResource(R.string.year_9)
    }

    Column(
        modifier = Modifier
            .background(color = Color.Gray, shape = RoundedCornerShape(10.dp))
            .width(300.dp)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = currentResource,
            fontSize = 40.sp,
        )
        Spacer(modifier = Modifier
            .height(20.dp)
            .fillMaxWidth())
        Row {
            Text(text = currentResource2, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
            Text(text = "($currentResource3)", fontSize = 19.sp)
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Greeting()
    }
}
