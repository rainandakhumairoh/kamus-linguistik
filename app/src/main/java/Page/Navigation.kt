package Page

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arabic.kamuslinguistik.Page.Disimpan
import com.arabic.kamuslinguistik.Page.HomeScreen
import com.arabic.kamuslinguistik.Page.PetunjukApp
import com.arabic.kamuslinguistik.Page.TentangApp

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable("HomeScreen") {
            HomeScreen(
                navController = navController
            )
        }

        composable("Disimpan") {
            Disimpan(
                navController = navController
            )
        }

        composable("PetunjukApp") {
            PetunjukApp(
                navController = navController
            )
        }

        composable("TentangApp") {
            TentangApp(
                navController = navController
            )
        }

    }

    }
