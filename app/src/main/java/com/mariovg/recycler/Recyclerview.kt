package com.mariovg.recycler

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SimpleRecycler() {
    val myList = listOf("Mario", "Antonio", "Valadez", "Perez", "Garcia")
    LazyColumn{
        item{
            Text(text = "Header")

        }
        items(10){
            Text(text = "Hola me llamo Item $it")
        }
        items(myList){
            Text(text = "Hola me llamo Item $it")
        }
        item{
            Text(text = "Footer")

        }
    }
}
