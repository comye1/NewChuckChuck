package com.example.newchuckchuck.screens.settings

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.newchuckchuck.navigation.BottomNavigationBar

@Composable
fun SettingsScreen(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "설정", style = MaterialTheme.typography.h5) },
            backgroundColor = Color.White,
            elevation = 0.dp
        )
    }) {
            TimeTableSection()
    }
}

@Composable
fun TimeTableSection() {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
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
        TimeTableDialog(
            subjectName = name,
            setSubjectName = { subName: String -> name = subName },
            checkedState = checkedState,
            closeDialog = { showDialog = false },
            saveTimeTable = {}
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

@Composable
fun TimeTableDialog(
    subjectName: String,
    closeDialog: () -> Unit,
    saveTimeTable: () -> Unit,
    checkedState: MutableState<Boolean>,
    setSubjectName: (String) -> Unit
) {
    AlertDialog(
        onDismissRequest = { closeDialog() },
        title = {
            Text(text = "수정")
        },
        text = {
            Column {
                TextField(
                    value = subjectName,
                    onValueChange = {
                        setSubjectName(it)
                    }
                )
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it }
                )

            }
        },
        confirmButton = {
            IconButton(onClick = {
                closeDialog()
                saveTimeTable()
            }) {
                Icon(
                    imageVector = Icons.Default.Done,
                    contentDescription = "complete"
                )
            }
        },
        dismissButton = {
            IconButton(onClick = closeDialog) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "cancel"
                )

            }
        }
    )
}

