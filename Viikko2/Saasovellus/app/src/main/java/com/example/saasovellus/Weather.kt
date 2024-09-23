package com.example.saasovellus

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherInfo() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tänään on puolipilvistä",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Row(){
            Image(
                painter = painterResource(id = R.drawable.baseline_thermostat_24),
                contentDescription = "Temperature Icon",
                modifier = Modifier
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = "15°C", fontSize = 30.sp)
            Spacer(modifier = Modifier.padding(10.dp))
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_outward_24),
                contentDescription = "Wind Direction",
                modifier = Modifier
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = "5 m/s", fontSize = 30.sp)
        }
    }
}