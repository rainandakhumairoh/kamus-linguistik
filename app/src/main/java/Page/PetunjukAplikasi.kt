package com.arabic.kamuslinguistik.Page

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.arabic.kamuslinguistik.R

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

            Text(
                text = "1. Menu Utama",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp,
                color =  Color(android.graphics.Color.parseColor("#206c7a")),
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Pada beranda awal tersedia 2 menu utama yang dapat dipilih yaitu Bagian 1 dan Bagian 2.",
                textAlign = TextAlign.Justify,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = R.drawable.mockup1),
                contentDescription = "petunjuk 1",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Image(
                painter = painterResource(id = R.drawable.mockup2),
                contentDescription = "petunjuk 1",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "2. Menu Sidebar",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp,
                color =  Color(android.graphics.Color.parseColor("#206c7a")),
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Pada bagian atas beranda terdapat icon menu, yang ketika diklik dapat memunculkan sidebar berisi beberapa fitur seperti:",
                textAlign = TextAlign.Justify,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "- Disimpan: memuat daftar istilah yang tersimpan." +
                        "\n- Petunjuk Aplikasi: memuat petunjuk penggunaan aplikasi." +
                        "\n- Tentang Aplikasi: memuat informasi tentang aplikasi.",

                textAlign = TextAlign.Left,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = R.drawable.mockup3),
                contentDescription = "petunjuk 2",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "3. Fitur Pencarian & Kategori Istilah",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp,
                color =  Color(android.graphics.Color.parseColor("#206c7a")),
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "a. Mencari Istilah",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "- Pilih menu Pencarian" +
                        "\n- Masukkan kata kunci (Arab, Indonesia atau Inggris)" +
                        "\n- Hasil pencarian akan muncul secara otomatis",

                textAlign = TextAlign.Left,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "b. Menyaring Istilah Berdasarkan Kategori",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "- Pilih menu Kategori" +
                        "\n- Pilih kategori yang diinginkan (misalnya Pragmatik, Sintaksis, dll)" +
                        "\n- Daftar istilah sesuai kategori akan muncul",

                textAlign = TextAlign.Left,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = R.drawable.mockup4),
                contentDescription = "petunjuk 3",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "4. Fitur Salin & Simpan Istilah",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp,
                color =  Color(android.graphics.Color.parseColor("#206c7a")),
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "a. Menyalin Istilah",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "- Ketuk ikon Copy di halaman detail istilah" +
                        "\n- Teks akan otomatis tersalin" +
                        "\n- Kamu bisa langsung menempelkannya (paste) ke catatan, dokumen, atau aplikasi lain",

                textAlign = TextAlign.Left,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "b. Menyimpan Istilah",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "- Ketuk ikon Bookmark di halaman detail istilah" +
                        "\n- Istilah akan masuk ke daftar tersimpan" +
                        "\n- Kamu bisa mengaksesnya melalui menu Disimpan pada sidebar",

                textAlign = TextAlign.Left,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = R.drawable.mockup5),
                contentDescription = "petunjuk 4",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Image(
                painter = painterResource(id = R.drawable.mockup6),
                contentDescription = "petunjuk 4",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "BONUS: Pengenalan Karakter",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 22.sp,
                color =  Color(android.graphics.Color.parseColor("#206c7a")),
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Pada aplikasi ini terdapat karakter animasi yang merepresentasikan setiap bahasa yang ada pada kamus. Terdapat empat karakter yang menggambarkan empat bahasa yaitu Arab, Indonesia, Inggris, dan Mandarin.",
                textAlign = TextAlign.Justify,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = R.drawable.character3),
                contentDescription = "petunjuk 5",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}