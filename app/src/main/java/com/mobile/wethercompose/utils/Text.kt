package com.mobile.mapcompose.utils

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.GoogleFont.Provider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontLoadingStrategy
import androidx.compose.ui.unit.TextUnit
import com.mobile.wethercompose.R


val boldtxt = FontFamily(
    Font(R.font.mulish_extrabold)
)



@Composable
fun BoldText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 18.sp,
    color: Color = Color.Black
) {
    Text(
        text = text,
        modifier = modifier,
        style = TextStyle(
            fontFamily = boldtxt,
            fontWeight = FontWeight.ExtraBold,
            fontSize = fontSize,
            color = color
        )
    )
}