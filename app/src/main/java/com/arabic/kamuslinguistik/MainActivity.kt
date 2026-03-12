package com.arabic.kamuslinguistik

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.arabic.kamuslinguistik.Page.HomeScreen
import com.arabic.kamuslinguistik.ui.theme.KamusLinguistikTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Install splash screen SEBELUM super.onCreate()
        installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KamusLinguistikTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    // State untuk mengontrol visibility splash screen
    val isSplashVisible = remember { mutableStateOf(true) }

    // Delay 2 detik sebelum hide splash screen
    LaunchedEffect(Unit) {
        delay(3000) // 5 detik
        isSplashVisible.value = false
    }

    if (isSplashVisible.value) {
        // Tampilkan Splash Screen
        SplashScreenContent()
    } else {
        // Tampilkan Home Screen
        HomeScreen()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SplashScreenContent() {
    Image(
        painter = painterResource(id = R.drawable.splashscreen),
        contentDescription = "Welcoming Picture",
        modifier = Modifier.fillMaxSize()
    )

}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    KamusLinguistikTheme {
        HomeScreen()
    }
}
