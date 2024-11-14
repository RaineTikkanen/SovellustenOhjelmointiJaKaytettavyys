package com.example.tehtava2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tehtava2.ui.theme.Tehtava2Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tehtava2Theme {
                TimerScreen()
            }
        }
    }
}

@Composable
fun TimerScreen(){
    val timerViewModel: TimerViewModel = viewModel()
    val seconds = timerViewModel.seconds.collectAsState()
    val minutes = timerViewModel.minutes.collectAsState()
    val hours = timerViewModel.hours.collectAsState()


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(0.5f))
        Row {
            TimerView(hours.value)
            Text(
                text = ":",
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold)
            TimerView(minutes.value)
            Text(
                text = ":",
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold)
            TimerView(seconds.value)
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}

@Composable
fun TimerView(time: Int){
    if (time < 10) {
        Text(
            text = "0$time",
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold)
    }
    else {
        Text(
            text = "$time",
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold)
    }
}

class TimerViewModel: ViewModel() {
    private val _seconds = MutableStateFlow(0)
    private val _minutes = MutableStateFlow(0)
    private val _hours = MutableStateFlow(0)
    val seconds: StateFlow<Int> get() = _seconds
    val minutes: StateFlow<Int> get() = _minutes
    val hours: StateFlow<Int> get() = _hours

    init {
        viewModelScope.launch {
            while (true) {
                delay(1000)
                _seconds.value++
                if (_seconds.value == 60) {
                    _seconds.value = 0
                    _minutes.value++
                    if (_minutes.value == 60) {
                        _minutes.value = 0
                        _hours.value++
                    }
                }
            }
        }
    }
}