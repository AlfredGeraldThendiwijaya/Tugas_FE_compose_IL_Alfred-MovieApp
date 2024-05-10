package com.example.myapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    val imageResources = listOf(
        R.drawable.hidden_love,
        R.drawable.falling_into_ur_smile,
        R.drawable.the_love_u_giveme,
        R.drawable.cloy,
        R.drawable.hotel_del_luna,
        R.drawable.chuang,
        R.drawable.alovesobeautiful,
        R.drawable.our_times,
        R.drawable.put_your,
        R.drawable.miracle,
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Profile") },
                modifier = Modifier.shadow(elevation = 4.dp),
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = { padding -> // Gunakan parameter padding di sini
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    contentAlignment = Alignment.Center, // Ini akan menempatkan gambar di tengah Box
                    modifier = Modifier
                        .padding(top = 50.dp)
                        .size(100.dp)
                        .clip(CircleShape) // Ini akan membuat gambar menjadi bulat
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.alfred),
                        contentDescription = "alfred",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Text(
                    text = "Alfred",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Text(
                    text = "alfred.gerald@student.pradita.ac.id",
                    fontSize = 15.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Text(
                    text = "Teknik Informatika Pradita University",
                    fontSize = 17.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
    )
}
