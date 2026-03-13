package com.arabic.kamuslinguistik.Page

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeScreen(navController: NavHostController) {
    // State untuk sidebar visibility
    val showSidebar = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(android.graphics.Color.parseColor("#ebebeb")))
    ) {
        topbar(
            onMenuClick = {
                showSidebar.value = true
            }
        )

        // Header dengan background warna teal
        Box(
            modifier = Modifier
                .height(220.dp)
                .fillMaxWidth()
                .background(color = Color(android.graphics.Color.parseColor("#206c7a")))
                .padding(32.dp)
                .padding(top = 10.dp),
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
                .fillMaxHeight()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Bagian 1
            BagianCard(
                title = "Bagian 1",
                description = "Istilah Arab-Indonesia, dilengkapi dengan penjelasan dan transkripsinya",
                characterImage = R.drawable.character1,
                onLihatClick = {
                    // TODO: Navigate to Bagian 1
                }
            )

            // Bagian 2
            BagianCard(
                title = "Bagian 2",
                description = "Istilah linguistik dengan padanannya dalam bahasa Arab, Indonesia, Inggris, dan Mandarin",
                characterImage = R.drawable.character2,
                onLihatClick = {
                    // TODO: Navigate to Bagian 2
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
    // OVERLAY - Semi-transparent background saat sidebar terbuka
    if (showSidebar.value) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black.copy(alpha = 0.5f))
                .clickable { showSidebar.value = false }
        )
    }


    // SIDEBAR - Animasi slide in dari kanan
    AnimatedVisibility(
        visible = showSidebar.value,
        enter = slideInHorizontally(
            initialOffsetX = { -it },  // Slide dari kanan
            animationSpec = tween(durationMillis = 300)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { -it },  // Slide ke kanan
            animationSpec = tween(durationMillis = 300)
        )
    ) {
        Sidebar(
            onClose = { showSidebar.value = false },
            onDisimpanClick = {
                // TODO: Handle Disimpan click
                showSidebar.value = false
                navController.navigate("Disimpan")
            },
            onPetunjukClick = {
                // TODO: Handle Petunjuk Aplikasi click
                showSidebar.value = false
                navController.navigate("PetunjukApp")
            },
            onTentangClick = {
                showSidebar.value = false
                navController.navigate("TentangApp")
            }
        )
    }

}

@Composable
fun topbar(
    onMenuClick: () -> Unit
) {
        Box(
            modifier = Modifier
                .height(87.dp)
                .fillMaxWidth()
                .background(color = Color(android.graphics.Color.parseColor("#206c7a")))
                .padding(10.dp)
                .padding(start = 20.dp, end = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    tint = Color.White,
                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                        .offset(y = 25.dp)
                        .clickable { onMenuClick() },
                    contentDescription = "menu"
                )
            }
        }
    }

@Composable
fun BagianCard(
    title: String,
    description: String,
    characterImage: Int,
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
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                painter = painterResource(id = characterImage),
                contentDescription = "Character Image"
            )
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
fun Sidebar(
    onClose: () -> Unit,
    onDisimpanClick: () -> Unit,
    onPetunjukClick: () -> Unit,
    onTentangClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Sidebar container
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(280.dp)
                .background(Color.White)
                .align(Alignment.TopStart)
        ) {

            // HEADER SIDEBAR
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(
                        Color(android.graphics.Color.parseColor("#206c7a")),
                        shape = RoundedCornerShape(bottomEnd = 20.dp)
                    )
                    .padding(16.dp)
                    .padding(top = 20.dp),
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // Logo
                    Image(
                        painter = painterResource(id = R.drawable.logodashboard),
                        contentDescription = "App Logo",
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(top = 30.dp),
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Menu items
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Disimpan
                SidebarMenuItem(
                    icon = Icons.Filled.BookmarkBorder,  // Gunakan icon drawable yang ada
                    label = "Disimpan",
                    onClick = onDisimpanClick
                )

                // Petunjuk Aplikasi
                SidebarMenuItem(
                    icon = Icons.Outlined.HelpOutline,  // Gunakan icon drawable yang ada
                    label = "Petunjuk Aplikasi",
                    onClick = onPetunjukClick
                )

                // Tentang Aplikasi
                SidebarMenuItem(
                    icon = Icons.Outlined.Info,  // Gunakan icon drawable yang ada
                    label = "Tentang Aplikasi",
                    onClick = onTentangClick
                )
            }
        }
    }
}

@Composable
fun SidebarMenuItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color(android.graphics.Color.parseColor("#206c7a")),
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = label,
                fontSize = 16.sp,
                color = Color(android.graphics.Color.parseColor("#206c7a")),
                fontWeight = FontWeight.Medium
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp)
        )
    }
}

@Composable
fun Divider(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = Color(android.graphics.Color.parseColor("#206c7a")),
            )
    )
}

