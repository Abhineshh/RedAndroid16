package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Surface(
                    modifier = Modifier
                ) {
                    LemonadeApp(modifier = Modifier)
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LemonadeApp(modifier: Modifier = Modifier){

        Column {
            Text(
                text = "Lemonade",
                Modifier
                    .background(Color.Yellow)
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(20.dp),
                textAlign = TextAlign.Center,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )

            LemonadeMaker()

        }

}

@Composable
fun LemonadeMaker(){
    var currentPicture by remember {
        mutableIntStateOf(1)
    }
    var squeezeCount by remember {
        mutableIntStateOf(0)
    }

    val imageResource = when(currentPicture){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    val textResource = when(currentPicture){
        1-> R.string.tree
        2-> R.string.lemon
        3->R.string.drink
        4->R.string.restart
        else-> R.string.tree
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = {
            if(currentPicture == 2 && squeezeCount<(3..6).random()){
                squeezeCount++;
            } else {
                currentPicture = if (currentPicture >= 4) 1 else currentPicture + 1
                squeezeCount = 0;
            }
                         },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Green,
                contentColor = Color.Red,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.LightGray
            ),
            shape = RoundedCornerShape(40.dp),

            ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = "lemon tree"
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = stringResource(textResource))
    }
}