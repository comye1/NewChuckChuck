package com.example.newchuckchuck.screens.settings

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = "설정", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(10.dp))
        TimeTableSection()

    }
}

@Composable
fun TimeTableSection() {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(15.dp)
            )
            .padding(5.dp)
    ) {
        Text(
            text = "시간표",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        LazyColumn {
            item {
                SubjectItem()
            }
        }
    }
}

@Composable
fun SubjectItem() {

    var showDialog by remember {
        mutableStateOf(false)
    }

    var name by remember {
        mutableStateOf("")
    }


    var checkedState = remember {
        mutableStateOf(false)
    }

    if (showDialog) {
        //todo : custom dialog 만들기 (TextField, Checkbox 포함)
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = {
                Text(text = "수정")
            },
            text = {
                Column() {
                    TextField(value = name, onValueChange = { name = it })
                    Checkbox(
                        checked = checkedState.value,
                        onCheckedChange = { checkedState.value = it }
                    )

                }
            },
            confirmButton = {
                IconButton(onClick = { showDialog = false }) {
                    Icon(
                        imageVector = Icons.Default.Done,
                        contentDescription = "complete"
                    )
                }
            },
            dismissButton = {
                IconButton(onClick = { showDialog = false }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "cancel"
                    )

                }
            }
        )
    }
    Column(
        Modifier
            .clickable {
                showDialog = true
            }
    ) {
        Text(text = "과목명", modifier = Modifier.padding(10.dp))
        Divider()
    }
}

