package com.arabic.kamuslinguistik.Page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arabic.kamuslinguistik.R
import com.arabic.kamuslinguistik.ui.theme.KamusLinguistikTheme


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color(android.graphics.Color.parseColor("#ebebeb")))
    ) {
        // Header dengan background warna teal
        Box(
            modifier = Modifier
                .height(220.dp)
                .fillMaxWidth()
                .background(color = Color(android.graphics.Color.parseColor("#206c7a")))
                .padding(32.dp)
                .padding(top = 42.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Logo
                Image(
                    painter = painterResource(id = R.drawable.logodashboard),
                    contentDescription = "App Logo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                )
            }
        }

        // Content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Bagian 1
            BagianCard(
                title = "Bagian 1",
                description = "Istilah Arab-Indonesia, dilengkapi dengan penjelasan dan transkripsinya",
                imageCount = 2,
                onLihatClick = {
                    // TODO: Navigate to Bagian 1
                }
            )

            // Bagian 2
            BagianCard(
                title = "Bagian 2",
                description = "Istilah linguistik dengan padanannya dalam bahasa Arab, Indonesia, Inggris, dan Mandarin",
                imageCount = 4,
                onLihatClick = {
                    // TODO: Navigate to Bagian 2
                }
            )
        }
    }
}

@Preview
@Composable
fun topbar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .background(color = Color(android.graphics.Color.parseColor("#206c7a")))
            .padding(start = 30.dp, end = 30.dp, top = 30.dp, bottom = 10.dp)
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically
    ) {
        Image(
            modifier = Modifier
                .width(60.dp)
                .height(60.dp),
            painter = painterResource(id = R.drawable.logodashboard),
            contentDescription = "Profile Image"
        )
    }
}

@Composable
fun BagianCard(
    title: String,
    description: String,
    imageCount: Int,
    onLihatClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color =  Color(android.graphics.Color.parseColor("#ebebeb")),
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = Color(android.graphics.Color.parseColor("#d9d9d9")),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Title
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color =  Color(android.graphics.Color.parseColor("#206c7a")),
            textAlign = TextAlign.Center
        )

        // Description
        Text(
            text = description,
            fontSize = 13.sp,
            color =  Color(android.graphics.Color.parseColor("#206c7a")),
            textAlign = TextAlign.Center,
            lineHeight = 18.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Character Images Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(imageCount) { index ->
                CharacterImage(index = index)
                if (index < imageCount - 1) {
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Button
        Button(
            onClick = onLihatClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(android.graphics.Color.parseColor("#206c7a"))
            ),
            shape = RoundedCornerShape(50.dp)
        ) {
            Text(
                text = "Lihat Selengkapnya",
                fontSize = 14.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun CharacterImage(index: Int) {
    // Placeholder untuk karakter
    // Ganti dengan actual image jika ada
    Box(
        modifier = Modifier
            .size(60.dp)
            .background(
                color = when (index) {
                    0 -> Color(0xFF4DB88D)  // Green
                    1 -> Color(0xFF8B6B47)  // Brown
                    2 -> Color(0xFF3B6B8B)  // Blue
                    else -> Color(0xFF8B4B3B) // Red
                },
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        // TODO: Replace with actual character images
        Text(
            text = "👤",
            fontSize = 32.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    KamusLinguistikTheme {
        HomeScreen()
    }
}