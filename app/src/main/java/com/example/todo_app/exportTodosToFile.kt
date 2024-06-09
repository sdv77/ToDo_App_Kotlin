package com.example.todo_app

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Locale

suspend fun exportTodosToFile(context: Context, todos: List<Todo>): File = withContext(Dispatchers.IO) {
    val file = File(context.cacheDir, "todos.csv")
    val writer = FileWriter(file)

    writer.append("ID,Title,Created At\n")
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

    todos.forEach { todo ->
        writer.append("${todo.id},${todo.title},${dateFormat.format(todo.createdAt)}\n")
    }

    writer.flush()
    writer.close()
    return@withContext file
}