package com.example.courseseller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courseseller.data.DataSource
import com.example.courseseller.model.CourseSeller
import com.example.courseseller.ui.theme.CourseSellerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseSellerTheme {
                CourseSellerApp()
            }
        }
    }
}

@Composable
fun CourseSellerApp() {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing
                    .asPaddingValues()
                    .calculateEndPadding(layoutDirection)
            )
    ) {
        CourseSellerList(courseSellerList = DataSource.topics)
    }
}

@Composable
fun CourseSellerList(courseSellerList: List<CourseSeller>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(200.dp),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        items(courseSellerList) { course ->
            CourseSellerCard(course)
        }
    }
}

@Composable
fun CourseSellerCard(courseSeller: CourseSeller) {
    Card(
        modifier = Modifier
            .height(100.dp)
            .padding(4.dp)
            .fillMaxSize()
    ) {
        Row {
            Image(
                painter = painterResource(courseSeller.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(68.dp),
                contentScale = ContentScale.FillHeight
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(courseSeller.stringResourceId),
                    fontSize = 15.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Sharp.Info, contentDescription = "Info icon")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "${courseSeller.availabilityNumber}")
                }
            }
        }
    }
}
