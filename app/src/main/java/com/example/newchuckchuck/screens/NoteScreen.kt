package com.example.newchuckchuck.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Label
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.newchuckchuck.R
import com.example.newchuckchuck.navigation.BottomNavigationBar

@Composable
fun NoteScreen(
    noteId: Int?,
    navController: NavHostController,
    navigateToImageScreen: (fileName: String) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("프로야구") },
                backgroundColor = Color.Transparent,
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowBack,
                            contentDescription = "navigateback"
                        )
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
                                    Icon(
                                        imageVector = Icons.Outlined.Check,
                                        contentDescription = ""
                                    )
                                }
                                Text("최근 수정")
                            }
                            DropdownMenuItem(onClick = { selectedSorting.value = "new" }) {
                                if (selectedSorting.value == "new") {
                                    Icon(
                                        imageVector = Icons.Outlined.Check,
                                        contentDescription = ""
                                    )
                                }
                                Text("최신 생성")
                            }
                            DropdownMenuItem(onClick = { selectedSorting.value = "old" }) {
                                if (selectedSorting.value == "old") {
                                    Icon(
                                        imageVector = Icons.Outlined.Check,
                                        contentDescription = ""
                                    )
                                }
                                Text("오래된 생성")
                            }
                            DropdownMenuItem(onClick = { selectedSorting.value = "ganada" }) {
                                if (selectedSorting.value == "ganada") {
                                    Icon(
                                        imageVector = Icons.Outlined.Check,
                                        contentDescription = ""
                                    )
                                }
                                Text("가나다")
                            }
                        }
                    }
                }
            )
        }
    ) {
        LazyColumn {
            item {
                PageItem(navigateToImageScreen = navigateToImageScreen)
            }
            item {
                PageItem(navigateToImageScreen = navigateToImageScreen)
            }
            item {
                PageItem(navigateToImageScreen = navigateToImageScreen)
            }
            item {
                PageItem(navigateToImageScreen = navigateToImageScreen)
            }
            item {
                PageItem(navigateToImageScreen = navigateToImageScreen)
            }
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

@Composable
fun PageItem(navigateToImageScreen: (fileName: String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 12.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(width = 2.dp, color = Color.LightGray),
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            PageTitle(title = "210831")

            PageKeywordItem(navigateToImageScreen = navigateToImageScreen)

            PageKeywordItem(navigateToImageScreen = navigateToImageScreen)
        }

    }
}

@Composable
fun PageTitle(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Label,
                tint = Color.DarkGray,
                contentDescription = "",
                modifier = Modifier.width(20.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.h6
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.Edit, contentDescription = "edit note")
        }
    }
}

@Composable
fun PageKeywordItem(navigateToImageScreen: (fileName: String) -> Unit) {
//    val folded = remember {
//        mutableStateOf(true)
//    }
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .clickable {
//                    folded.value = !folded.value
//                }
//                .padding(5.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text("keyword", style = MaterialTheme.typography.body1)
//            if (folded.value) {
//                Icon(imageVector = Icons.Outlined.ExpandMore, contentDescription = "unfold")
//            } else {
//                Icon(imageVector = Icons.Outlined.ExpandLess, contentDescription = "fold")
//            }
//        }
//        if (!folded.value) {
//            KeywordDescription()
//        }
//        }
    Row(modifier = Modifier.padding(5.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {

                }
        ) {
            Text(
                "keyword what what",
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            ClickableImage(navigateToImageScreen = navigateToImageScreen)
            Spacer(modifier = Modifier.height(5.dp))
            Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry.")
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
    Divider()
}

@Composable
fun ClickableImage(navigateToImageScreen: (fileName: String) -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.cat),
        contentDescription = "",
        modifier = Modifier.clickable {
            navigateToImageScreen("aaaa")
        }
    )

}

