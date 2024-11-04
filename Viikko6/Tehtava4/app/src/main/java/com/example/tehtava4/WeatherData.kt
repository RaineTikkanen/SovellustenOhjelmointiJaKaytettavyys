package com.example.tehtava4

data class WeatherData(
    val weather: List<Weather>,
    val main: Main,
    val wind: Wind
)

data class Weather(
    val main: String,
)

data class Main(
    val temp: Double
)

data class Wind(
    val speed: Double,
    val deg: Double
)
