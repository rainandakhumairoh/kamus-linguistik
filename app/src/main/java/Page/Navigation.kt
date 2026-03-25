package Page

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.arabic.kamuslinguistik.Page.BantuanApp
import com.arabic.kamuslinguistik.Page.Disimpan
import com.arabic.kamuslinguistik.Page.HomeScreen
import com.arabic.kamuslinguistik.Page.ListIstilah1
import com.arabic.kamuslinguistik.Page.ListIstilah2
import com.arabic.kamuslinguistik.Page.PetunjukApp
import com.arabic.kamuslinguistik.Page.TentangApp
import com.arabic.kamuslinguistik.Page.DetailIstilahBagian1
import com.arabic.kamuslinguistik.Page.DetailIstilahBagian2

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable("HomeScreen") {
            HomeScreen(
                navController = navController
            )
        }

        composable("ListIstilah1") {
            ListIstilah1(
                navController = navController,
                context = LocalContext.current
            )
        }

        composable("ListIstilah2") {
            ListIstilah2(
                navController = navController,
                context = LocalContext.current
            )
        }

        composable(
            "detailIstilah1/{transkripsiArab}/{arti}/{penjelasan}/{istilahArab}/{kategoriIstilah}"
        ) { backStackEntry ->
            val transkripsiArab = backStackEntry.arguments?.getString("transkripsiArab")
            val arti = backStackEntry.arguments?.getString("arti")
            val penjelasan = backStackEntry.arguments?.getString("penjelasan")
            val istilahArab = backStackEntry.arguments?.getString("istilahArab")
            val kategoriIstilah = backStackEntry.arguments?.getString("kategoriIstilah")

            DetailIstilahBagian1(
                navController = navController,
                transkripsiArab = transkripsiArab,
                arti = arti,
                penjelasan = penjelasan,
                istilahArab = istilahArab,
                kategoriIstilah = kategoriIstilah
            )
        }


        // ✅ BAGIAN 2 - DETAIL
        composable(
            "detailIstilah2/{istilahInggris}/{prononInggris}/{arti}/{istilahArab}/{transkripsiArab}/{istilahMandarin}/{transkripsiMandarin}/{prononMandarin}/{kategoriIstilah}"
        ) { backStackEntry ->
            val istilahInggris = backStackEntry.arguments?.getString("istilahInggris")
            val prononInggris = backStackEntry.arguments?.getString("prononInggris")
            val arti = backStackEntry.arguments?.getString("arti")
            val istilahArab = backStackEntry.arguments?.getString("istilahArab")
            val transkripsiArab = backStackEntry.arguments?.getString("transkripsiArab")
            val istilahMandarin = backStackEntry.arguments?.getString("istilahMandarin")
            val transkripsiMandarin = backStackEntry.arguments?.getString("transkripsiMandarin")
            val prononMandarin = backStackEntry.arguments?.getString("prononMandarin")
            val kategoriIstilah = backStackEntry.arguments?.getString("kategoriIstilah")

            DetailIstilahBagian2(
                navController = navController,
                istilahInggris = istilahInggris,
                prononInggris = prononInggris,
                arti = arti,
                istilahArab = istilahArab,
                transkripsiArab = transkripsiArab,
                istilahMandarin = istilahMandarin,
                transkripsiMandarin = transkripsiMandarin,
                prononMandarin = prononMandarin,
                kategoriIstilah = kategoriIstilah
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

        composable("BantuanApp") {
            BantuanApp(
                navController = navController
            )
        }
    }
}