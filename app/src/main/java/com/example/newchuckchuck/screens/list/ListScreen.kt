package com.example.newchuckchuck.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListScreen() {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = "List screen 뭐라고 쓸까~~", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn() {

        }
    }
}