package com.example.tehtava4

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.round


@Composable
fun WindView(speed: Double, direction: Double) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.wind),
            contentDescription = "temperature",
            modifier = Modifier
                .padding(10.dp)
                .size(50.dp)
        )
        Text(
            fontSize = 50.sp,
            text = "${round(speed)}m/s",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 50.sp,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(1.0f, 1.0f),
                    blurRadius = 15f
                )
            )
        )
        Image(
            painter = painterResource(id = R.drawable.arrow),
            contentDescription = "temperature",
            modifier = Modifier
                .rotate(direction.toFloat()-90)
                .padding(10.dp)
                .size(50.dp)
        )
    }
}