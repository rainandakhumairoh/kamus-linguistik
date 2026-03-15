package com.arabic.kamuslinguistik.Page

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.arabic.kamuslinguistik.R
import androidx.compose.foundation.lazy.items

data class Istilah(
    val istilahLatin: String,
    val arti: String,
    val istilahArab: String
)

val dummyIstilah = listOf(
    Istilah("Aliyyatu al-jarayani", "Mekanisme Aliran Udara", "آلِيَّة الجَرَيَان"),
    Istilah("Badiylun, alaw", "Alo", "بَدِيلٌ، أَلَو"),
    Istilah("Tatsaqqufun", "Akulturasi", "تَثَقُّف"),
    Istilah("Jumlatun", "Kalimat", "جُمْلَة")
)

@Composable
fun ListIstilah1(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color =  Color(android.graphics.Color.parseColor("#ebebeb")),)
    ) {

        HeaderSection(navController)

        IstilahList(dummyIstilah)

    }
}

@Composable
fun HeaderSection(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#206c7a")))
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier
                    .size(28.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(R.drawable.character1),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        SearchBar()

        KategoriSection()

    }
}

@Composable
fun SearchBar() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Cari di sini") },
            modifier = Modifier
                .weight(1f)
                .height(50.dp),
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.White, CircleShape),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color(0xFF206C7A)
            )

        }

    }
}

@Composable
fun KategoriSection() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Kategori:",
            color = Color.White,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.width(6.dp))

        DropdownKategori("Mikrolinguistik")

        Spacer(modifier = Modifier.width(6.dp))

        DropdownKategori("Makrolinguistik")

    }
}

@Composable
fun DropdownKategori(text: String) {

    Box(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(50.dp))
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text
                , color = Color(0xFF206C7A),
                fontSize = 12.sp
            )

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null
            )
        }

    }
}

@Composable
fun IstilahList(data: List<Istilah>) {

    LazyColumn {

        items(data) { item ->

            IstilahRow(item)

        }

    }
}

@Composable
fun IstilahRow(item: Istilah) {

    Column {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = item.istilahLatin,
                    fontSize = 12.sp,
                    color =  Color(android.graphics.Color.parseColor("#206c7a")),
                )

                Text(
                    text = "'${item.arti}'",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color =  Color(android.graphics.Color.parseColor("#206c7a")),
                )

            }

            Text(
                text = item.istilahArab,
                fontSize = 18.sp,
                color =  Color(android.graphics.Color.parseColor("#206c7a"))
            )

        }

        Divider(
            color =  Color(android.graphics.Color.parseColor("#92babc"))
        )

    }
}


