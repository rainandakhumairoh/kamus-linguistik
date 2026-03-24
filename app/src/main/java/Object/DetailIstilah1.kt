package com.arabic.kamuslinguistik.Page

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.Icon
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
import androidx.navigation.NavController

@Composable
fun DetailIstilahBagian1(
    navController: NavController,
    transkripsiArab: String?,
    arti: String?,
    penjelasan: String?,
    istilahArab: String?,
    kategoriIstilah: String?
) {
    val istilah = DetailIstilah1Data(
        transkripsiArab = transkripsiArab ?: "",
        arti = arti ?: "",
        penjelasan = penjelasan ?: "",
        istilahArab = istilahArab ?: "",
        kategoriIstilah = kategoriIstilah ?: ""
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#ebebeb")))
    ) {
        // ✅ HEADER DENGAN BACK BUTTON
        HeaderDetail1(navController)

        // ✅ CONTENT SCROLLABLE
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            DetailContent1(istilah)
        }
    }
}

@Composable
fun HeaderDetail1(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#206c7a")))
            .padding(16.dp)
            .height(60.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.White,
            modifier = Modifier
                .size(28.dp)
                .offset(y = 20.dp)
                .clickable {
                    navController.popBackStack()
                }
        )
    }
}

@Composable
fun DetailContent1(istilah: DetailIstilah1Data) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ✅ MAIN CARD - TITLE SECTION
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(12.dp))
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // ✅ ISTILAH ARAB (TITLE - BESAR DAN BOLD)
                Text(
                    text = istilah.istilahArab,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(android.graphics.Color.parseColor("#206c7a")),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // ✅ TRANSKRIPSI ARAB (SUBTITLE)
                Text(
                    text = istilah.transkripsiArab,
                    fontSize = 14.sp,
                    color = Color(android.graphics.Color.parseColor("#206c7a")),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                // ✅ ARTI - DISPLAY TERPUSAT
                Text(
                    text = istilah.arti,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(android.graphics.Color.parseColor("#206c7a")),
                    textAlign = TextAlign.Center,
                    lineHeight = 22.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // ✅ PENJELASAN CARD
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(12.dp))
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                // ✅ LABEL PENJELASAN
                Text(
                    text = "Penjelasan",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(android.graphics.Color.parseColor("#206c7a")),
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                        .fillMaxWidth()
                )

                // ✅ DIVIDER
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .background(Color(android.graphics.Color.parseColor("#206c7a")))
                        .padding(bottom = 16.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // ✅ INDONESIAN TEXT (Penjelasan dalam Bahasa Indonesia)
                Text(
                    text = istilah.penjelasan,
                    fontSize = 13.sp,
                    color = Color(android.graphics.Color.parseColor("#206c7a")),
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Justify
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // ✅ KATEGORI INFO CARD
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Kategori:",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(android.graphics.Color.parseColor("#206c7a"))
                )

                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .background(
                            Color(android.graphics.Color.parseColor("#206c7a")).copy(alpha = 0.1f),
                            RoundedCornerShape(50.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = istilah.kategoriIstilah,
                        fontSize = 12.sp,
                        color = Color(android.graphics.Color.parseColor("#206c7a")),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // ✅ ACTION BUTTONS
        ActionButtonsBagian1(istilah)

        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun ActionButtonsBagian1(istilah: DetailIstilah1Data) {
    val context = LocalContext.current
    val isSaved = remember { mutableStateOf(isIstilahSaved(context, istilah.istilahArab)) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // ✅ COPY BUTTON
        Box(
            modifier = Modifier
                .size(45.dp)
                .background(Color(android.graphics.Color.parseColor("#206c7a")), CircleShape)
                .clickable {
                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                    val clip = ClipData.newPlainText(
                        "Istilah",
                        "${istilah.istilahArab}\n${istilah.transkripsiArab}\n${istilah.arti}\n${istilah.penjelasan}"
                    )
                    clipboard.setPrimaryClip(clip)
                    Toast.makeText(context, "Istilah disalin!", Toast.LENGTH_SHORT).show()
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.ContentCopy,
                contentDescription = "Copy",
                tint = Color.White,
                modifier = Modifier.size(22.dp)
            )
        }

        Spacer(modifier = Modifier.width(24.dp))

        // ✅ BOOKMARK BUTTON
        Box(
            modifier = Modifier
                .size(45.dp)
                .background(
                    Color(android.graphics.Color.parseColor("#206c7a")),
                    CircleShape
                )
                .clickable {
                    if (isSaved.value) {
                        deleteIstilahFromPreferences(context, istilah.istilahArab)
                        isSaved.value = false
                        Toast.makeText(context, "Istilah dihapus dari simpanan", Toast.LENGTH_SHORT).show()
                    } else {
                        val savedItem = SavedIstilah(
                            istilahArab = istilah.istilahArab,
                            transkripsiArab = istilah.transkripsiArab,
                            arti = istilah.arti,
                            kategoriIstilah = istilah.kategoriIstilah,
                            source = "Bagian1"
                        )
                        saveIstilahToPreferences(context, savedItem)
                        isSaved.value = true
                        Toast.makeText(context, "Istilah disimpan!", Toast.LENGTH_SHORT).show()
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = if (isSaved.value) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                contentDescription = "Bookmark",
                tint = Color.White,
                modifier = Modifier.size(22.dp)
            )
        }
    }
}