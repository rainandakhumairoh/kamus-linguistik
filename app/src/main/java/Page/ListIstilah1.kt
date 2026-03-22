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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.arabic.kamuslinguistik.R
import kotlinx.coroutines.launch
import org.json.JSONArray
import android.content.Context
import android.net.Uri
import androidx.compose.material.icons.filled.Close

// ✅ DATA CLASS UNTUK BAGIAN 1 (5 fields)
data class IstilahData1(
    val transkripsiArab: String,
    val arti: String,
    val penjelasan: String,
    val istilahArab: String,
    val kategoriIstilah: String
)

val kategoriMap1 = mapOf(
    "Mikrolinguistik" to listOf(
        "Fonetik/Fonologi",
        "Sintaksis",
        "Morfologi",
        "Semantik",
        "Analisis Wacana"
    ),
    "Makrolinguistik" to listOf(
        "Pragmatik",
        "Sosiolinguistik",
        "Psikolinguistik",
        "Leksikologi/Leksikografi",
        "Stilistika",
        "Neurolinguistik",
        "Linguistik Terapan"
    ),
    "All/General" to listOf(
        "All/General"
    )
)

// ✅ Load JSON dari assets
fun loadIstilahFromJson1(context: Context): List<IstilahData1> {
    return try {
        val jsonString = context.assets.open("istilah_bagian1.json").bufferedReader().use {
            it.readText()
        }
        val jsonArray = JSONArray(jsonString)
        val istilahList1 = mutableListOf<IstilahData1>()

        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val istilah1 = IstilahData1(
                transkripsiArab = jsonObject.optString("transkripsiArab", ""),
                arti = jsonObject.optString("arti", ""),
                penjelasan = jsonObject.optString("penjelasan", ""),
                istilahArab = jsonObject.optString("istilahArab", ""),
                kategoriIstilah = jsonObject.optString("kategoriIstilah", "")
            )
            istilahList1.add(istilah1)
        }
        istilahList1
    } catch (e: Exception) {
        e.printStackTrace()
        emptyList()
    }
}

// ✅ Filter berdasarkan kategori dan pencarian
fun filterIstilahData1(
    data: List<IstilahData1>,
    kategori: String? = null,
    searchText: String = ""
): List<IstilahData1> {
    return data.filter { item ->
        val matchKategori = kategori == null ||
                kategori == "Pilih Kategori" ||
                item.kategoriIstilah.contains(kategori, ignoreCase = true)

        val matchSearch = searchText.isEmpty() ||
                item.transkripsiArab.contains(searchText, ignoreCase = true) ||
                item.arti.contains(searchText, ignoreCase = true) ||
                item.istilahArab.contains(searchText, ignoreCase = true) ||
                item.penjelasan.contains(searchText, ignoreCase = true)

        matchKategori && matchSearch
    }
}

@Composable
fun ListIstilah1(navController: NavController, context: Context) {
    var allData by remember { mutableStateOf<List<IstilahData1>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var selectedKategori by remember { mutableStateOf<String?>(null) }
    var searchText by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    // ✅ Load data dari JSON saat pertama kali
    remember {
        scope.launch {
            allData = loadIstilahFromJson1(context)
            isLoading = false
        }
        Unit
    }

    val displayData1 = filterIstilahData1(allData, selectedKategori, searchText)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#ebebeb")))
    ) {
        HeaderSection1(
            navController,
            onKategoriChange = { selectedKategori = it },
            onSearchChange = { searchText = it },
            onResetFilter = { selectedKategori = null },
            selectedKategori = selectedKategori,
            searchText = searchText
        )

        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Color(android.graphics.Color.parseColor("#206c7a")))
            }
        } else {
            IstilahList1(displayData1, navController)
        }
    }
}

@Composable
fun HeaderSection1(
    navController: NavController,
    onKategoriChange: (String) -> Unit,
    onSearchChange: (String) -> Unit,
    onResetFilter: () -> Unit,
    selectedKategori: String?,
    searchText: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#206c7a")))
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
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

        SearchBar1(onSearchChange, searchText)

        KategoriSection1(onKategoriChange, onResetFilter, selectedKategori)
    }
}

@Composable
fun SearchBar1(onSearchChange: (String) -> Unit, searchText: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = searchText,
            onValueChange = onSearchChange,
            placeholder = { Text("Cari di sini", fontSize = 12.sp) },
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
fun KategoriSection1(onKategoriChange: (String) -> Unit, onResetFilter: () -> Unit, selectedKategori: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Kategori:",
                color = Color.White,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.width(15.dp))

            DropdownKategoriHierarki1(onKategoriChange, selectedKategori)
        }

        // ✅ TOMBOL RESET FILTER (BARU!)
        if (selectedKategori != null && selectedKategori != "Pilih Kategori") {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(Color.White, CircleShape)
                    .clickable {
                        onResetFilter()
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Reset Filter",
                    tint = Color(android.graphics.Color.parseColor("#206c7a")),
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownKategoriHierarki1(onKategoriChange: (String) -> Unit, selectedKategori: String?) {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(selectedKategori ?: "Pilih Kategori") }
    var currentMenu by remember { mutableStateOf("utama") }

    remember(selectedKategori) {
        selectedText = selectedKategori ?: "Pilih Kategori"
    }

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
            modifier = Modifier.background(Color.White)
        ) {
            if (currentMenu == "utama") {
                kategoriMap1.keys.forEach { kategoriUtama ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                kategoriUtama,
                                color = Color(android.graphics.Color.parseColor("#206c7a"))
                            )
                        },
                        onClick = {
                            currentMenu = kategoriUtama
                        }
                    )
                }
            } else {
                kategoriMap1[currentMenu]?.forEach { subKategori ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                subKategori,
                                color = Color(android.graphics.Color.parseColor("#206c7a"))
                            )
                        },
                        onClick = {
                            selectedText = subKategori
                            onKategoriChange(subKategori)
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
                    text = {
                        Text(
                            "← Kembali",
                            color = Color(android.graphics.Color.parseColor("#206c7a"))
                        )
                    },
                    onClick = {
                        currentMenu = "utama"
                    }
                )
            }
        }
    }
}

@Composable
fun IstilahList1(data: List<IstilahData1>, navController: NavController) {
    if (data.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Tidak ada data yang ditemukan", color = Color.Gray)
        }
    } else {
        LazyColumn {
            items(data) { item ->
                IstilahRow1(item, navController)
            }
        }
    }
}

@Composable
fun IstilahRow1(item: IstilahData1, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
            .clickable {
                val route = "detailIstilah1/${Uri.encode(item.transkripsiArab)}/${Uri.encode(item.arti)}/${Uri.encode(item.penjelasan)}/${Uri.encode(item.istilahArab)}/${Uri.encode(item.kategoriIstilah)}"
                navController.navigate(route)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = item.transkripsiArab,
                fontSize = 12.sp,
                color = Color(android.graphics.Color.parseColor("#206c7a")),
            )

            Text(
                text = item.istilahArab,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(android.graphics.Color.parseColor("#206c7a")),
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Text(
            text = item.arti,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(android.graphics.Color.parseColor("#206c7a")),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = item.kategoriIstilah,
            fontSize = 10.sp,
            color = Color(android.graphics.Color.parseColor("#92babc")),
            fontWeight = FontWeight.Light
        )

        Divider(color = Color(android.graphics.Color.parseColor("#92babc")))
    }
}