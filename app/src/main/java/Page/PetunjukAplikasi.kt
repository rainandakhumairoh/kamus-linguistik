package com.arabic.kamuslinguistik.Page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun PetunjukApp(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEDEDED))
    ) {

        // TOPBAR
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(Color(0xFF206C7A)),
            contentAlignment = Alignment.Center
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(top = 30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Text(
                    text = "Petunjuk Aplikasi",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // CONTENT
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState())
        ) {

//            Text(
//                text = "Aplikasi Kamus Linguistik Multibahasa ini dirancang untuk membantu pengguna memahami berbagai istilah linguistik secara lebih mudah dan komprehensif. Aplikasi ini menyediakan daftar istilah linguistik yang dilengkapi dengan penjelasan serta padanannya dalam beberapa bahasa, yaitu Arab, Indonesia, Inggris, dan Mandarin.",
//                fontSize = 14.sp,
//                textAlign = TextAlign.Justify,
//                lineHeight = 22.sp,
//                color = Color.DarkGray
//
//            )
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Text(
//                text = "Melalui aplikasi ini, pengguna dapat mempelajari konsep-konsep dasar hingga lanjutan dalam bidang linguistik dengan cara yang praktis dan terstruktur. Aplikasi ini juga diharapkan dapat menjadi sumber referensi yang bermanfaat bagi mahasiswa, peneliti, maupun masyarakat umum yang tertarik pada kajian bahasa.",
//                fontSize = 14.sp,
//                textAlign = TextAlign.Justify,
//                lineHeight = 22.sp,
//                color = Color.DarkGray
//            )
        }
    }
}