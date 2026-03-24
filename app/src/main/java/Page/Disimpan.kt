package com.arabic.kamuslinguistik.Page

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun Disimpan(navController: NavHostController) {
    val context = LocalContext.current
    val savedIstilahList = remember { mutableStateOf(getSavedIstilah(context)) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEDEDED))
    ) {

        // ✅ TOPBAR
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
                    text = "Disimpan",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // ✅ CONTENT
        if (savedIstilahList.value.isEmpty()) {
            // ✅ EMPTY STATE
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Belum Ada Istilah yang Disimpan",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF206C7A),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = "Mulai menyimpan istilah yang Anda pelajari dengan mengklik tombol bookmark pada halaman detail istilah.",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp
                )
            }
        } else {
            // ✅ DAFTAR ISTILAH YANG DISIMPAN
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = savedIstilahList.value,
                    key = { it.id }
                ) { istilah ->
                    SavedIstilahItem(
                        istilah = istilah,
                        onItemClick = {
                            // NAVIGATE KE DETAIL ISTILAH
                            if (istilah.source == "Bagian1" || istilah.source.isEmpty()) {
                                navigateToDetailIstilah1(
                                    navController = navController,
                                    transkripsiArab = istilah.transkripsiArab,
                                    arti = istilah.arti,
                                    penjelasan = "", // Tidak tersimpan
                                    istilahArab = istilah.istilahArab,
                                    kategoriIstilah = istilah.kategoriIstilah
                                )
                            } else if (istilah.source == "Bagian2") {
                                navigateToDetailIstilah2(
                                    navController = navController,
                                    istilahInggris = "",
                                    prononInggris = "",
                                    arti = istilah.arti,
                                    istilahArab = istilah.istilahArab,
                                    transkripsiArab = istilah.transkripsiArab,
                                    istilahMandarin = "",
                                    transkripsiMandarin = "",
                                    prononMandarin = "",
                                    kategoriIstilah = istilah.kategoriIstilah
                                )
                            }
                        },
                        onDelete = {
                            deleteIstilahFromPreferences(context, istilah.istilahArab)
                            savedIstilahList.value = getSavedIstilah(context)
                        }
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}

@Composable
fun SavedIstilahItem(
    istilah: SavedIstilah,
    onItemClick: () -> Unit,
    onDelete: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(12.dp))
            .clickable { onItemClick() }
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    // ✅ ISTILAH ARAB
                    Text(
                        text = istilah.istilahArab,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF206C7A),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    // ✅ TRANSKRIPSI
                    Text(
                        text = istilah.transkripsiArab,
                        fontSize = 12.sp,
                        color = Color(0xFF206C7A),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    // ✅ ARTI
                    Text(
                        text = istilah.arti,
                        fontSize = 13.sp,
                        color = Color.DarkGray,
                        lineHeight = 18.sp
                    )
                }

                // ✅ DELETE BUTTON
                IconButton(
                    onClick = onDelete,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Delete",
                        tint = Color(0xFF206C7A),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // ✅ KATEGORI BADGE
            if (istilah.kategoriIstilah.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .background(
                            Color(0xFF206C7A).copy(alpha = 0.1f),
                            RoundedCornerShape(50.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = istilah.kategoriIstilah,
                        fontSize = 11.sp,
                        color = Color(0xFF206C7A),
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            // ✅ SOURCE BADGE
            if (istilah.source.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .background(
                            Color(0xFF206C7A).copy(alpha = 0.05f),
                            RoundedCornerShape(4.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "dari ${istilah.source}",
                        fontSize = 10.sp,
                        color = Color(0xFF206C7A),
                        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                    )
                }
            }
        }
    }
}
fun navigateToDetailIstilah1(
    navController: NavHostController,
    transkripsiArab: String,
    arti: String,
    penjelasan: String,
    istilahArab: String,
    kategoriIstilah: String
) {
    val encodedTranskripsi = URLEncoder.encode(transkripsiArab, StandardCharsets.UTF_8.toString())
    val encodedArti = URLEncoder.encode(arti, StandardCharsets.UTF_8.toString())
    val encodedPenjelasan = URLEncoder.encode(penjelasan, StandardCharsets.UTF_8.toString())
    val encodedIstilah = URLEncoder.encode(istilahArab, StandardCharsets.UTF_8.toString())
    val encodedKategori = URLEncoder.encode(kategoriIstilah, StandardCharsets.UTF_8.toString())

    navController.navigate(
        "detailIstilah1/$encodedTranskripsi/$encodedArti/$encodedPenjelasan/$encodedIstilah/$encodedKategori"
    )
}

fun navigateToDetailIstilah2(
    navController: NavHostController,
    istilahInggris: String,
    prononInggris: String,
    arti: String,
    istilahArab: String,
    transkripsiArab: String,
    istilahMandarin: String,
    transkripsiMandarin: String,
    prononMandarin: String,
    kategoriIstilah: String
) {
    val parts = listOf(
        istilahInggris, prononInggris, arti, istilahArab,
        transkripsiArab, istilahMandarin, transkripsiMandarin,
        prononMandarin, kategoriIstilah
    ).map { URLEncoder.encode(it, StandardCharsets.UTF_8.toString()) }

    navController.navigate(
        "detailIstilah2/${parts.joinToString("/")}"
    )
}
