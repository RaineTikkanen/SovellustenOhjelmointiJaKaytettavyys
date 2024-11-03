package org.example

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

fun main() {
    println("Hello World!")
    var todo =  RetrofitInstance.toDoService.getTodoById()
    println(todo)
}

data class ToDoItem(
    val userID: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)


interface ToDoService {
    @GET("/todos")
    suspend fun getTodos(): List<ToDoItem>
    @GET("/todos/1")
    suspend fun getTodoById(): ToDoItem
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