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
import androidx.compose.foundation.layout.offset
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
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import com.arabic.kamuslinguistik.data.IstilahEntity1
import com.arabic.kamuslinguistik.viewmodel.IstilahViewModel1

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

val kategoriMap = mapOf(

    "Mikrolinguistik" to listOf(
        "Sintaksis",
        "Morfologi",
        "Semantik",
        "Fonologi"
    ),

    "Makrolinguistik" to listOf(
        "Pragmatik",
        "Sosiolinguistik",
        "Psikolinguistik",
        "Antropolinguistik"
    )
)

@Composable
fun ListIstilah1(
    navController: NavController,
    viewModel: IstilahViewModel1
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.seedDatabase1(context)
    }

    val istilahList1 by viewModel.istilahList1.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color =  Color(android.graphics.Color.parseColor("#ebebeb")),)
    ) {

        HeaderSection(navController)

        IstilahList1(istilahList1)

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
                    .offset(y = 30.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(R.drawable.character1),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )
        }

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
            placeholder = { Text("Cari di sini")
                TextStyle(fontSize = 12.sp)},
            modifier = Modifier
                .weight(1f)
                .height(50.dp),
            shape = RoundedCornerShape(50.dp),
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
                tint = Color(android.graphics.Color.parseColor("#206c7a")),
            )

        }

    }
}

@Composable
fun KategoriSection() {

    var kategoriUtama by remember { mutableStateOf("Mikrolinguistik") }
    var subKategori by remember { mutableStateOf("Pilih Subkategori") }

    val subList = kategoriMap[kategoriUtama] ?: emptyList()

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

        Spacer(modifier = Modifier.width(15.dp))

        DropdownKategoriHierarki()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownKategoriHierarki() {

    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("Pilih Kategori") }
    var currentMenu by remember { mutableStateOf("utama") }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {

        val textColor =
            if (selectedText == "Pilih Kategori") Color.Gray
            else Color(android.graphics.Color.parseColor("#206c7a"))

        TextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            textStyle = TextStyle(fontSize = 12.sp, color = textColor),
            modifier = Modifier
                .menuAnchor()
                .width(220.dp)
                .height(45.dp),
            shape = RoundedCornerShape(50.dp),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded)
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
                currentMenu = "utama"
            },
            modifier = Modifier.background(
                Color(android.graphics.Color.parseColor("#ffffff")))
        ) {

            if (currentMenu == "utama") {

                kategoriMap.keys.forEach {

                    DropdownMenuItem(
                        text = { Text(it, color = Color(android.graphics.Color.parseColor("#206c7a"))) },
                        onClick = {
                            currentMenu = it
                        }
                    )

                }

            } else {

                kategoriMap[currentMenu]?.forEach {

                    DropdownMenuItem(
                        text = { Text(it, color = Color(android.graphics.Color.parseColor("#206c7a"))) },
                        onClick = {
                            selectedText = it
                            expanded = false
                            currentMenu = "utama"
                        }
                    )

                }

                Divider(
                    color = Color(android.graphics.Color.parseColor("#206c7a")),
                    thickness = 1.dp
                )

                DropdownMenuItem(
                    text = { Text("← Kembali", color = Color(android.graphics.Color.parseColor("#206c7a"))) },
                    onClick = {
                        currentMenu = "utama"
                    }
                )

            }

        }
    }
}


@Composable
fun IstilahList1(data: List<IstilahEntity1>) {

    LazyColumn {

        items(data) { item ->

            IstilahRow(item)

        }

    }
}

@Composable
fun IstilahRow(item: IstilahEntity1) {

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


