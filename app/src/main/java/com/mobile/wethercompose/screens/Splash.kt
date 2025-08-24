package com.mobile.wethercompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.wethercompose.R
import com.mobile.mapcompose.utils.boldtxt
import com.mobile.mapcompose.utils.sw20
import kotlinx.coroutines.delay


@Composable
fun Splash(modifier: Modifier = Modifier, onTimeout: () -> Unit = {}) {
    LaunchedEffect(true) {
        delay(2000)
        onTimeout()
    }

    Column(modifier = modifier.padding(start = 10.dp,), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start) {



          Row {
              Image(
                  painter = painterResource(R.drawable.menu),
                  contentDescription = "",
                  modifier = Modifier.size(27.dp)
              )

              sw20()

              Text("Food XYZ", fontFamily = boldtxt, color = Color(0xFFE03055), fontSize = 23.sp)
          }

        


    }

}