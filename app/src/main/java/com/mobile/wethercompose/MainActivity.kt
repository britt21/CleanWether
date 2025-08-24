package com.mobile.wethercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mobile.wethercompose.screens.HomeScreen
import com.mobile.wethercompose.screens.Splash
import com.mobile.wethercompose.screens.WeatherDetailScreen
import com.mobile.wethercompose.ui.theme.WetherComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WetherComposeTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "splash"
                ) {
                    composable("splash") {
                        Splash(
                            modifier = Modifier.fillMaxSize(),
                            onTimeout = { navController.navigate("home") }
                        )
                    }
                    composable("home") {
                        var favoriteCity by remember { mutableStateOf("") }
                        HomeScreen(
                            favoriteCity = if (favoriteCity.isBlank()) null else favoriteCity,
                            onSaveFavorite = { city -> favoriteCity = city },
                            onSearch = { city ->
                                if (city.isNotBlank()) {
                                    navController.navigate("details/${city}")
                                }
                            }
                        )
                    }
                    composable("details/{city}") { backStackEntry ->
                        val city = backStackEntry.arguments?.getString("city") ?: ""
                        // TODO: Replace with actual API call logic for description/temp. Placeholder values for now:
                        WeatherDetailScreen(
                            city = city,
                            description = "Clear sky",
                            temperature = 25.0
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WetherComposeTheme {
        Greeting("Android")
    }
}