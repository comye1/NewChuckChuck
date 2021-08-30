package com.example.newchuckchuck.screens

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun NoteScreen(noteId: Int?, navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("프로야구") },
            backgroundColor = Color.Transparent,
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "navigateback")
                }
            },
            elevation = 0.dp,
            actions = {
                // RowScope here, so these icons will be placed horizontally
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Outlined.Search, contentDescription = "Localized description")
                }
                val expanded = remember {
                    mutableStateOf(false)
                }
                val selectedSorting = remember {
                    mutableStateOf("latest")
                }
                IconButton(onClick = { expanded.value = true }) {

                    Icon(Icons.Outlined.Sort, contentDescription = "Localized description")
                    DropdownMenu(
                        expanded = expanded.value,
                        onDismissRequest = { expanded.value = false }) {
                        DropdownMenuItem(onClick = { selectedSorting.value = "latest" }) {
                            if (selectedSorting.value == "latest") {
                                Icon(imageVector = Icons.Outlined.Check, contentDescription = "")
                            }
                            Text("최근 수정")
                        }
                        DropdownMenuItem(onClick = { selectedSorting.value = "new" }) {
                            if (selectedSorting.value == "new") {
                                Icon(imageVector = Icons.Outlined.Check, contentDescription = "")
                            }
                            Text("최신 생성")
                        }
                        DropdownMenuItem(onClick = { selectedSorting.value = "old" }) {
                            if (selectedSorting.value == "old") {
                                Icon(imageVector = Icons.Outlined.Check, contentDescription = "")
                            }
                            Text("오래된 생성")
                        }
                        DropdownMenuItem(onClick = { selectedSorting.value = "ganada" }) {
                            if (selectedSorting.value == "ganada") {
                                Icon(imageVector = Icons.Outlined.Check, contentDescription = "")
                            }
                            Text("가나다")
                        }
                    }
                }
            }
        )
    }) {
        Text(text = "Note $noteId")
    }
}