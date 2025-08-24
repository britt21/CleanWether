package com.mobile.wethercompose.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mobile.wethercompose.R
import com.mobile.wethercompose.WetherViewModel
import com.mobile.wethercompose.ui.theme.whitecolor
import com.mobile.wethercompose.ui.theme.yellowColor
import com.mobile.wethercompose.utils.appbtn
import androidx.compose.runtime.collectAsState
import com.google.gson.Gson

@Composable
fun HomeScreen(
    favoriteCity: String?,
    onSaveFavorite: (String) -> Unit,
    onSearch: (String) -> Unit,
    viewmodel: WetherViewModel = hiltViewModel()
) {
    var gson = Gson()
    var appcontext = LocalContext.current
    var city by remember { mutableStateOf(favoriteCity ?: "") }
    var isFavorite by remember { mutableStateOf(favoriteCity != null) }

    val isLoading by viewmodel.loading.collectAsState()
    val error by viewmodel.error.collectAsState()
    val wetherResponse by viewmodel.liveWether.collectAsState()

   error?.let {
        Toast.makeText(appcontext, it, Toast.LENGTH_SHORT).show()
        viewmodel.error.value = null
    }


   wetherResponse?.let { data ->
       var response = gson.toJson(data)
       onSearch(response)
       viewmodel.liveWether.value = null
    }



    Box(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 8.dp), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Enter City", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(10.dp))
            OutlinedTextField(
                value = city,
                onValueChange = { city = it },
                label = { Text("City Name") },
                singleLine = true
            )
            Spacer(Modifier.height(10.dp))
            IconButton(onClick = {
                onSaveFavorite(city)
                isFavorite = true
            }) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Star else Icons.Outlined.StarBorder,
                    contentDescription = "Favorite City",
                    tint = if (isFavorite) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                )
            }
            Spacer(Modifier.height(10.dp))
           Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,) {   appbtn (onClick = {

                println("CITY: "+ city)
                viewmodel.getwether(city, appcontext.getString(R.string.appid_key))

                             }, enabled = city.isNotBlank(), text = "Search",
                color = yellowColor,
                textColor = whitecolor, isLoading = isLoading


            )
        }
    }
}
}
