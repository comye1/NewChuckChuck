package com.example.newchuckchuck.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Sort
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@Composable
fun ListScreen(navController: NavHostController) {

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("노트") },
            backgroundColor = Color.Transparent,
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
        LazyColumn {
            item {
                NoteListItem(onClick = { noteId: Int -> navController.navigate("note/${noteId}") })
            }
            item {
                Spacer(modifier = Modifier.height(50.dp))
            }
        }

    }
}

@Composable
fun NoteListItem(onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 10.dp)
            .clickable {
                onClick(0)
            },
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(width = 3.dp, color = Color.LightGray),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "프로야구",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
            )
            Text(text = "오늘", style = MaterialTheme.typography.body2)
        }

    }
}

