package com.mobile.wethercompose.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.mobile.wethercompose.ui.theme.inetbg


@Composable
fun appbtn(
    isLoading: Boolean = false,
    enabled: Boolean = true,
    color: Color = inetbg,
    height: Dp = 50.dp,
    width: Dp? = null,
    radius: Dp = 8.dp,
    text: String? = null,
    textColor: Color = Color.Black,
    fontSize: TextUnit = TextUnit.Unspecified,
    borderColor: Color = Color.Transparent,
    borderWidth: Dp = 1.dp,
    content: @Composable () -> Unit = {},
    onClick: () -> Unit
) {
    val localConfig = LocalConfiguration.current

    Button(
        enabled = enabled,
        onClick = onClick,
        border = BorderStroke(borderWidth, borderColor),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(radius),
        modifier = Modifier
            .width(width ?: localConfig.screenWidthDp.dp)
            .height(height)
    ) {
        if (isLoading) CircularProgressIndicator(
            modifier = Modifier.size(24.dp),
            strokeWidth = 2.dp,
            color = Color.White
        )
        else if (text != null) Text(
            text = text,
            fontSize = fontSize,
            color = textColor
        ) else content()
    }
}