package com.example.newchuckchuck.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = "Home screen", style = MaterialTheme.typography.h5)
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn() {
                item {
                    SubjectSection()
                }
                item {
                    SubjectSection()
                }
                item {
                    SubjectSection()
                }
                item {
                    SubjectSection()
                }
                item {
                    SubjectSection()
                }
                item {
                    SubjectSection()
                }
                item {
                    Spacer(modifier = Modifier.height(40.dp))
                }
            }
        }
    }
}

@Composable
fun SubjectSection() {

    var newText by remember {
        mutableStateOf("")
    }

    var keyWords = remember {
        mutableStateListOf("키움", "기아", "삼성", "롯데")
    }


    Card(elevation = 10.dp) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxWidth()
                    .wrapContentHeight(align = CenterVertically)
                    .padding(10.dp)
            ) {
                Text(text = "과목명", style = MaterialTheme.typography.h6)
            }
            Row(
                modifier = Modifier
                    .height(100.dp)
                    .padding(10.dp)
            ) {
                keyWords.forEach {
                    Text(text = it, style = MaterialTheme.typography.body2)
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
            Row(
                verticalAlignment = CenterVertically,
                modifier = Modifier.padding(10.dp)
            ) {
                OutlinedTextField(
                    value = newText,
                    onValueChange = { newText = it },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0, 102, 51),
                        unfocusedBorderColor = Color.LightGray,
                        cursorColor = Color(0, 102, 51)
                    ),
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(10.dp))
                IconButton(
                    onClick = {
                        keyWords.add(newText)
                        newText = ""
                    },
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Icon(
                        imageVector = Icons.Outlined.AddCircle,
                        contentDescription = "add",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}

