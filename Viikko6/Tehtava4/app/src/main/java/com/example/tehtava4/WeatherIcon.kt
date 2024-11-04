package com.example.tehtava4

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun WeatherIcon(weather: Weather) {
    var recource = R.drawable.sunny
    when (weather.main) {
        "Clouds" -> recource = R.drawable.cloudy
        "Rain" -> recource = R.drawable.rain
        "Snow" -> recource = R.drawable.snow
    }
    Image(
        painter = painterResource(id = recource),
        contentDescription = "weathericon",
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
    )

}