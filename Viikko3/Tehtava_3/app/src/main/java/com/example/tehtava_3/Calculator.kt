package com.example.tehtava_3

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun Calculator() {
    var highPressure by remember { mutableStateOf("") }
    var lowPressure by remember { mutableStateOf("") }

    Text(text=(stringResource(R.string.AppIntroduction)))
    Text(text=(stringResource(R.string.AppInstruction)))

    TextField(
        value = highPressure.toString(),
        maxLines = 1,
        onValueChange = { highPressure = it },
        label = { Text(stringResource(R.string.enter_high_pressure)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

    TextField(
        value = lowPressure.toString(),
        maxLines = 1,
        onValueChange = { lowPressure = it },
        label = { Text(stringResource(R.string.enter_low_pressure)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
    Row() {
        if (highPressure.toIntOrNull() == null || lowPressure.toIntOrNull() == null) {
            Text(text = (stringResource(R.string.NoValues)))
        } else {
            val highPressure = highPressure.toInt()
            val lowPressure = lowPressure.toInt()
            Text(stringResource(R.string.ResultHeader))
            Text(text=(" "))
            if (highPressure < 120 && lowPressure < 80) {
                Text(stringResource(R.string.normal))
            } else if (highPressure in 120..129 && lowPressure < 80) {
                Text(stringResource(R.string.elevated))
            } else if (highPressure in 130..139 || lowPressure in 80..89) {
                Text(stringResource(R.string.high))
            } else if (highPressure >= 140 || lowPressure >= 90) {
                Text(stringResource(R.string.very_high))
            } else if (highPressure >= 180 || lowPressure >= 120) {
                Text(stringResource(R.string.extremely_high_see_doctor_immediately))
            }
        }
    }

}