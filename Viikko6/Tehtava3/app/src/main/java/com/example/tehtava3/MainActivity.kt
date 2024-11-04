package com.example.tehtava3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tehtava3.ui.theme.Tehtava3Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tehtava3Theme {
                App()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun App() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },
        content = { innerPadding ->
            ToDoList(innerPadding)
        }
    )
}


@Composable
fun ToDoList(innerPadding: PaddingValues) {
    var todos by remember() { mutableStateOf<List<ToDoItem>?>(null) }
    LaunchedEffect(Unit) {
        launch(Dispatchers.IO) {
            todos = RetrofitInstance.toDoService.getTodos()
        }
    }

    LazyColumn(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        todos?.forEach { todo: ToDoItem ->
            item {
                Card(
                    modifier = Modifier.padding(8.dp)
                ){
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize()
                    ) {
                        Text(text = todo.title, style = MaterialTheme.typography.titleMedium)
                        Text(text = "Completed: ${todo.completed}")
                    }
                }
            }
        }
    }
}

interface ToDoService {
    @GET("/todos")
    suspend fun getTodos(): List<ToDoItem>
}

object RetrofitInstance{
    val toDoService: ToDoService by lazy{
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ToDoService::class.java)
    }
}


data class ToDoItem(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)