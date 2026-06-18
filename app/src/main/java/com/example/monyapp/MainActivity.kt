package com.example.monyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.monyapp.ui.screens.AddTransactionScreen
import com.example.monyapp.ui.screens.CategoryScreen
import com.example.monyapp.ui.screens.HomeScreen
import com.example.monyapp.ui.screens.StatisticsScreen
import com.example.monyapp.viewmodel.TransactionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonyAppTheme {
                MonyAppMain()
            }
        }
    }
}

@Composable
fun MonyAppMain() {
    val navController = rememberNavController()
    val viewModel: TransactionViewModel = hiltViewModel()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showBottomBar = currentRoute in listOf("home", "statistics", "categories")

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                MonyBottomNavigation(navController, currentRoute)
            }
        }
    ) { padding ->
        MonyAppNavigation(navController, viewModel, Modifier.padding(padding))
    }
}

@Composable
fun MonyBottomNavigation(navController: NavHostController, currentRoute: String?) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = currentRoute == "home",
            onClick = {
                if (currentRoute != "home") {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                    }
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Star, contentDescription = "Statistics") },
            label = { Text("Stats") },
            selected = currentRoute == "statistics",
            onClick = {
                if (currentRoute != "statistics") {
                    navController.navigate("statistics") {
                        popUpTo("home")
                    }
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.List, contentDescription = "Categories") },
            label = { Text("Categories") },
            selected = currentRoute == "categories",
            onClick = {
                if (currentRoute != "categories") {
                    navController.navigate("categories") {
                        popUpTo("home")
                    }
                }
            }
        )
    }
}

@Composable
fun MonyAppNavigation(navController: NavHostController, viewModel: TransactionViewModel, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "home", modifier = modifier) {
        composable("home") {
            HomeScreen(
                viewModel = viewModel,
                onAddTransactionClick = { navController.navigate("add_transaction") }
            )
        }
        composable("add_transaction") {
            AddTransactionScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("statistics") {
            StatisticsScreen(viewModel = viewModel)
        }
        composable("categories") {
            CategoryScreen()
        }
    }
}

@Composable
fun MonyAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(), // Use lightColorScheme or darkColorScheme as preferred
        content = content
    )
}
