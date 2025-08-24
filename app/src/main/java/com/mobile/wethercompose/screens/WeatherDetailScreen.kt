package com.mobile.wethercompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import com.mobile.wethercompose.data.response.wether_response.WetherResponse

@Composable
fun WeatherDetailScreen(city: String, description: String, temperature: Double) {

    var gson = Gson()
    var response = gson.fromJson(city, WetherResponse::class.java)
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Card(Modifier.padding(32.dp)) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Country: ${response.sys?.country} Lat: ${response.coord?.lat} Lon: ${response.coord?.lon}", style = MaterialTheme.typography.headlineMedium)
                Spacer(Modifier.height(16.dp))
                Text(text = "$description", style = MaterialTheme.typography.titleMedium)
                Spacer(Modifier.height(12.dp))
                Text(
                    text = "${temperature}°C",
                    fontSize = 36.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
