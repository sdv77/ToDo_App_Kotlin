package com.example.todo_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Date

class TodoViewModel : ViewModel() {
    private var _todoList = MutableLiveData<List<Todo>>()
    val todoList : LiveData<List<Todo>> = _todoList

    fun getAllTodo(){
        _todoList.value = TodoManager.getAllTodo().reversed()
    }

    fun addTodo(title: String, createdAt: Date) {
        TodoManager.addTodo(title, createdAt)
        getAllTodo()
    }
    fun deleteTodo(id : Int){
        TodoManager.deleteTodo(id)
        getAllTodo()
    }
}