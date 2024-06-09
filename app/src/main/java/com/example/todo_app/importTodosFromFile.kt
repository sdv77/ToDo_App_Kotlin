package com.example.todo_app

import android.content.Context
import android.net.Uri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

suspend fun importTodosFromFile(context: Context, uri: Uri, viewModel: TodoViewModel) = withContext(
    Dispatchers.IO) {
    val inputStream = context.contentResolver.openInputStream(uri)
    val reader = BufferedReader(InputStreamReader(inputStream))
    val todos = mutableListOf<Todo>()
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

    reader.useLines { lines ->
        lines.drop(1).forEach { line -> // Пропускаем заголовок
            val parts = line.split(",")
            if (parts.size == 3) {
                val id = parts[0].toIntOrNull() ?: 0
                val title = parts[1]
                val createdAt = dateFormat.parse(parts[2]) ?: Date()
                todos.add(Todo(id = id, title = title, createdAt = createdAt))
            }
        }
    }

    todos.forEach { todo ->
        viewModel.addTodo(
            title = todo.title,
            createdAt = todo.createdAt
        )
    }
}