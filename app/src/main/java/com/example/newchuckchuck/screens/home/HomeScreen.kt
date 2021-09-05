package com.example.newchuckchuck.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Label
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.newchuckchuck.getDateString
import com.example.newchuckchuck.navigation.BottomNavigationBar
import com.example.newchuckchuck.ui.theme.DeepGreen
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Column() {
                    Text(text = "Home screen", style = MaterialTheme.typography.h5)
                    Text(text = getDateString(), style = MaterialTheme.typography.body2)
                }
            },
            backgroundColor = Color.White,
            elevation = 0.dp
        )
    }) {

        LazyColumn() {
            item {
                NoteItem()
            }
            item {
                NoteItem()
            }
            item {
                NoteItem()
            }
            item {
                NoteItem()
            }
            item {
                NoteItem()
            }
            item {
                NoteItem()
            }
            item {
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }


    // todo : 태블릿 위한 레이아웃 어떻게 ??


}

@Composable
fun NoteItem() {

    var newText by remember {
        mutableStateOf("")
    }

    var keyWords = remember {
        mutableStateListOf("키움히어로즈", "기아", "삼성", "롯데")
    }

    Card(
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(width = 3.dp, color = Color.LightGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
//            .background(color = MaterialTheme.colors.surface)
        ) {
            Row(
                modifier = Modifier
                    .wrapContentHeight(align = CenterVertically)
            ) {
//                Icon(imageVector = Icons.Outlined.Notes, contentDescription = "", tint = DeepGreen)
//                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "프로야구",
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.ExtraBold,
//                    color = DeepGreen
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Label,
                    tint = Color.DarkGray,
                    contentDescription = "",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "소제목입니다 키움 너무못해",
                    style = MaterialTheme.typography.subtitle1
                )
            }

            FlowRow(
                modifier = Modifier
                    .wrapContentHeight()
            ) {
                keyWords.forEach {
                    KeyWord(text = it)
                }
            }
            Row(
                verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
            ) {
                OutlinedTextField(
                    value = newText,
                    onValueChange = { newText = it },
                    placeholder = { Text(text = "키워드") },
                    textStyle = MaterialTheme.typography.body1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = DeepGreen,
                        unfocusedBorderColor = Color.LightGray,

                        cursorColor = DeepGreen,
                        backgroundColor = Color.White,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.White,
//                        disabledIndicatorColor = Color.Transparent
                    ),
                    shape = CircleShape,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyWords.add(newText)
                            newText = ""
                        }
                    )
                )
//            Spacer(modifier = Modifier.width(10.dp))
                IconButton(
                    onClick = {
                        // 뷰모델 addNewKeyword 호출
                        keyWords.add(newText)
                        newText = ""
                        //todo: 유효성 검증
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "add",
                        modifier = Modifier
                            .size(50.dp)
                            .weight(1f),
                        tint = DeepGreen
                    )
                }
            }
        }
    }

}

@Composable
fun KeyWord(text: String) {
    Row(
        verticalAlignment = CenterVertically,
        modifier = Modifier
//                .background(color = Color.LightGray)
            .padding(vertical = 5.dp)

    ) {
        Text(
            text = text,
            modifier = Modifier
                .border(width = 1.dp, color = DeepGreen, shape = CircleShape)
                .padding(vertical = 5.dp, horizontal = 10.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
    }
}
