package com.example.tehtava4

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import kotlin.math.round


@Composable
fun WeatherView(innerPadding: PaddingValues) {
    var weather by remember() { mutableStateOf<WeatherData?>(null) }
    LaunchedEffect(Unit) {
        launch(Dispatchers.IO) {
            try {
                weather = RetrofitInstance.weatherService.getWeather()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(30.dp)
    ) {
        Spacer(modifier = Modifier.height(80.dp))
        if (weather != null) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    WeatherIcon(weather!!.weather[0])
                        TemperatureView(weather!!.main.temp)
                        WindView(weather!!.wind.speed, weather!!.wind.deg)
                    }
        } else {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
            ){
                Text(
                    text = "Loading...",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}



interface WeatherService {
    @GET("/data/2.5/weather?lat=61.4980214&lon=23.7603118&appid=45db5fa72e69fea5846b6a995fbe330f")
    suspend fun getWeather(): WeatherData
}

object RetrofitInstance{
    val weatherService: WeatherService by lazy{
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService::class.java)
    }
}