package com.example.viikko2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun topBar(){
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(20.dp),
        text = "Valuuttamuunnin",
        fontSize = 30.sp)
}