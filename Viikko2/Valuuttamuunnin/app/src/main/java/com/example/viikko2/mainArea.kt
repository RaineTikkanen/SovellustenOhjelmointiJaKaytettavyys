package com.example.viikko2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun mainArea(){
    Column(){
        Text(
            modifier = Modifier
                .padding(10.dp),
            text="Lähtövaluutta:",
            fontSize = 20.sp)
        Row(){
            Text(
                modifier = Modifier
                    .padding(20.dp)
                    .weight(1f),
                text="EUR",
                fontSize = 30.sp)
            TextField(
                modifier = Modifier
                    .padding(20.dp)
                    .weight(2f),
                value = "", onValueChange = {})
        }
        Text(
            modifier = Modifier
                .padding(10.dp),
            text="Kohdevaluutta:",
            fontSize = 20.sp)
        Row(){
            Text(
                modifier = Modifier
                    .padding(20.dp)
                    .weight(1f),
                text="USD",
                fontSize = 30.sp)
            Text(
                modifier = Modifier

                    .padding(20.dp)
                    .weight(2f),
                text="0.00$",
                fontSize = 30.sp,
            )
        }
    }
}