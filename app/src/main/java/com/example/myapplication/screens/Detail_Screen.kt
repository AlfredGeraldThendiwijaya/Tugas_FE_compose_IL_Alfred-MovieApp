package com.example.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(filmTitle: String, filmSinopsis: String, imageResource: Int, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Detail Screen") },
                modifier = Modifier.shadow(elevation = 4.dp),
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
            ) {
                Row {
                    Column {
                        Image(
                            painter = painterResource(id = imageResource),
                            contentDescription = "Film Image",
                            modifier = Modifier
                                .size(150.dp)
                                .padding(top = 16.dp)
                        )
                        Text(
                            text = "Good Movie",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier
                                .padding(top=10.dp)
                                .offset(x = 35.dp)

                        )

                    }

                    Column(
                    ) {
                        Text(
                            text = filmTitle,
                            style = MaterialTheme.typography.displayMedium.copy(fontSize = 25.sp, fontWeight = FontWeight.Bold),
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .offset(x = (-15).dp)
                        )
                        Row {
                            for (i in 1..5) {
                                Icon(
                                    imageVector = Icons.Filled.Star,
                                    contentDescription = "Star Icon",
                                    tint = Color(0xFFFFE100),
                                    modifier = Modifier
                                        .offset(y = (-5).dp)
                                        .offset(x = (-15).dp)
                                )
                            }
                        }
                        Text(
                            text = "Rating: 5/5",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier
                                .offset(x = (-15).dp)

                        )
                        Text(
                            text = "Synopsis:",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .offset(x = (-15).dp)

                        )
                    }

                }

                Text(
                    text = filmSinopsis,
                    style = MaterialTheme.typography.displaySmall.copy(fontSize = 15.sp, lineHeight = 20.sp),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(start = 120.dp)
                        .offset(y = (-25).dp)
                )
            }
        }
    )
}

