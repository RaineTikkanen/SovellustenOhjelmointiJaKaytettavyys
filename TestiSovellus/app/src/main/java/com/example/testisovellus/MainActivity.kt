package com.example.testisovellus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloApp()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HelloApp() {
    Column() {
        var greeting by remember{ mutableStateOf("Click to say hello")}

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(10.dp)
        ) {
            Text(text = "My App", fontSize = 30.sp)
        }
        Text(text= greeting,
            fontSize = 30.sp,
            modifier = Modifier
                .weight(12f)
                .height(1.dp)
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(16.dp)
                .padding(16.dp)
                .align(Alignment.CenterHorizontally))


        Button(onClick = {
            greeting="Hello"
        },
            modifier = Modifier
                .weight(1f)
                .padding(10.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
            ) {
            Text(text = "Say Hello",)

        }
    }
}




