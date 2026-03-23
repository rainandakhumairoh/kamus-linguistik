package Object

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

// ✅ DATA CLASS UNTUK DETAIL BAGIAN 2
data class DetailIstilah2(
    val istilahInggris: String,
    val prononInggris: String,
    val arti: String,
    val istilahArab: String,
    val transkripsiArab: String,
    val istilahMandarin: String,
    val transkripsiMandarin: String,
    val prononMandarin: String,
    val kategoriIstilah: String
)

@Composable
fun DetailIstilahBagian2(
    navController: NavController,
    istilahInggris: String?,
    prononInggris: String?,
    arti: String?,
    istilahArab: String?,
    transkripsiArab: String?,
    istilahMandarin: String?,
    transkripsiMandarin: String?,
    prononMandarin: String?,
    kategoriIstilah: String?
) {
    val istilah = DetailIstilah2(
        istilahInggris = istilahInggris ?: "",
        prononInggris = prononInggris ?: "",
        arti = arti ?: "",
        istilahArab = istilahArab ?: "",
        transkripsiArab = transkripsiArab ?: "",
        istilahMandarin = istilahMandarin ?: "",
        transkripsiMandarin = transkripsiMandarin ?: "",
        prononMandarin = prononMandarin ?: "",
        kategoriIstilah = kategoriIstilah ?: ""
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#ebebeb")))
    ) {
        // ✅ HEADER DENGAN BACK BUTTON
        HeaderDetail2(navController)

        // ✅ CONTENT SCROLLABLE
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            DetailContent2(istilah)
        }
    }
}

@Composable
fun HeaderDetail2(navController: NavController) {
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
fun DetailContent2(istilah: DetailIstilah2) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ✅ MAIN CARD
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(12.dp))
                .padding(20.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // ✅ ISTILAH ARAB (TITLE - BESAR DAN BOLD)
                        Text(
                            text = istilah.istilahArab,
                            fontSize = 20.sp,
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
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Divider(
                    color = Color(android.graphics.Color.parseColor("#92babc")),
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                // ✅ ARTI (MEANING)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Text(
                        text = "Arti",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(android.graphics.Color.parseColor("#206c7a")),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = istilah.arti,
                        fontSize = 14.sp,
                        color = Color(android.graphics.Color.parseColor("#206c7a")),
                        lineHeight = 20.sp
                    )
                }

                Divider(
                    color = Color(android.graphics.Color.parseColor("#92babc")),
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 16.dp)
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Mandarin",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#92babc")),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        Text(
                            text = istilah.istilahMandarin,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#206c7a")),
                            modifier = Modifier.padding(bottom = 4.dp)
                        )

                        Text(
                            text = istilah.transkripsiMandarin,
                            fontSize = 12.sp,
                            color = Color(android.graphics.Color.parseColor("#206c7a"))
                        )

                        Text(
                            text = istilah.prononMandarin,
                            fontSize = 12.sp,
                            color = Color(android.graphics.Color.parseColor("#206c7a")),
                            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                        )
                    }

                    Divider(
                        color = Color(android.graphics.Color.parseColor("#92babc")),
                        thickness = 1.dp,
                        modifier = Modifier
                            .width(1.dp)
                            .height(120.dp)
                    )

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "Inggris",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(android.graphics.Color.parseColor("#92babc")),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        Text(
                            text = istilah.istilahInggris,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(android.graphics.Color.parseColor("#206c7a")),
                            modifier = Modifier.padding(bottom = 4.dp)
                        )

                        Text(
                            text = "/IPA: ${istilah.prononInggris}/",
                            fontSize = 12.sp,
                            color = Color(android.graphics.Color.parseColor("#206c7a")),
                            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                        )
                    }
                }

                Divider(
                    color = Color(android.graphics.Color.parseColor("#92babc")),
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                // ✅ KATEGORI
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Kategori:",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(android.graphics.Color.parseColor("#206c7a"))
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Box(
                        modifier = Modifier
                            .background(
                                Color(android.graphics.Color.parseColor("#92babc")).copy(alpha = 0.1f),
                                RoundedCornerShape(50.dp)
                            )
                            .padding(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = istilah.kategoriIstilah,
                            fontSize = 11.sp,
                            color = Color(android.graphics.Color.parseColor("#206c7a")),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // ✅ ACTION BUTTONS
        ActionButtonsBagian2()

        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun ActionButtonsBagian2() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // ✅ COPY BUTTON
        Box(
            modifier = Modifier
                .size(45.dp)
                .background(Color(android.graphics.Color.parseColor("#206c7a")), CircleShape)
                .clickable {
                    // TODO: Implement copy to clipboard
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
                .background(Color(android.graphics.Color.parseColor("#206c7a")), CircleShape)
                .clickable {
                    // TODO: Implement bookmark
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.BookmarkBorder,
                contentDescription = "Bookmark",
                tint = Color.White,
                modifier = Modifier.size(22.dp)
            )
        }
    }
}