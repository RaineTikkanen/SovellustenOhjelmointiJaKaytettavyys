package com.example.tehtava_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Converter()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Converter (){
    Column(){
        TopBar(stringResource(R.string.HeaderText))
        MainArea()
        Spacer(modifier = Modifier.weight(1f))
        convertButton()
    }
}

@Composable
fun convertButton(){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Text(text = stringResource(R.string.convertButtonText),
            fontSize = 30.sp
        )
    }
}