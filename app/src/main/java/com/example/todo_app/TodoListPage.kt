package com.example.todo_app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier

@Composable
fun TodoListPage(){

    val todoList = getFakeTodo()

    Column(
        modifier = Modifier.fillMaxHeight()
            .padding(8.dp)
    ){
        LazyColumn(
            content = {
                itemsIndexed(todoList){index: Int, item: Todo ->
                    Text(text = item.toString())
                }
            }
        )

    }

}

