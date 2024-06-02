package com.example.todo_app

import java.time.Instant
import java.util.Date

object TodoManager {

    private val todoList = mutableListOf<Todo>()
    fun getAllTodo() : List<Todo> {
        return todoList
    }
    fun addTodo(title: String, createdAt: Date) {
        todoList.add(Todo(System.currentTimeMillis().toInt(), title, createdAt))
    }
    fun deleteTodo(id : Int){
        todoList.removeIf {
            it.id==id
        }
    }
}