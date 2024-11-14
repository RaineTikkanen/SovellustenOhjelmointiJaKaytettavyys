package com.example.tehtava1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.tehtava1.ui.theme.Tehtava1Theme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { innerPadding ->
                Column(
                    modifier=Modifier
                        .padding(innerPadding)
                        .padding(16.dp)
                ) {
                    CounterScreen()
                }
        }
    }
}

@Preview
@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel()) {
    val count = viewModel.count.value
    Column {
        Text(text = "Count: $count")
        Button(onClick = { viewModel.increment() }) {
            Text(text = "Increment")
        }
        Button(onClick = { viewModel.decrement() }) {
            Text(text = "Decrement")
        }
        }
    }
}

class CounterViewModel : ViewModel() {
    var count = mutableStateOf(0)
    private set
    fun increment() {
        count.value++
    }
    fun decrement() {
        count.value--
    }
}