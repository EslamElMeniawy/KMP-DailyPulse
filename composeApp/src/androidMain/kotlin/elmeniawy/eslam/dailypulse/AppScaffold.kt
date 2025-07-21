package elmeniawy.eslam.dailypulse

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import elmeniawy.eslam.dailypulse.screens.ArticlesScreen
import elmeniawy.eslam.dailypulse.screens.Screens
import elmeniawy.eslam.dailypulse.screens.SystemInfoScreen

/**
 * AppScaffold
 *
 * Created by Eslam El-Meniawy on 17-Jul-2025 at 2:19 PM.
 */

@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold(contentWindowInsets = WindowInsets(0.dp)) {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreen(
                onSystemInfoButtonClick = { navController.navigate(Screens.SYSTEM_INFO.route) }
            )
        }
        composable(Screens.SYSTEM_INFO.route) {
            SystemInfoScreen(
                onBackButtonClick = { navController.popBackStack() }
            )
        }
    }
}