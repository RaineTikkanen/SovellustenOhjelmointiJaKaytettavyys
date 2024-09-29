package com.example.tehtava_1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainArea(){
    Column(){
        Text(
            modifier = Modifier
                .padding(10.dp),
            text= stringResource(R.string.startingCurrency),
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
            text= stringResource(R.string.goalCurrency),
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