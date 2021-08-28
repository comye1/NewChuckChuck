package com.example.newchuckchuck.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.newchuckchuck.data.Note
import com.example.newchuckchuck.getDateString
import com.example.newchuckchuck.ui.theme.DeepGreen
import com.example.newchuckchuck.ui.theme.LightGreen
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun HomeScreen() {
    // todo : 태블릿 위한 레이아웃 어떻게 ??
    Surface(color = MaterialTheme.colors.surface) {

        Column() {
            Text(text = "Home screen 뭐라고 쓸까~~", style = MaterialTheme.typography.h5)
            Text(text = getDateString(), style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(10.dp))
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
                    Spacer(modifier = Modifier.height(40.dp))
                }
            }
        }
    }

}

@Composable
fun NoteItem() {

    var newText by remember {
        mutableStateOf("")
    }

    var keyWords = remember {
        mutableStateListOf("키움", "기아", "삼성", "롯데")
    }

    Card() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
//            .background(color = MaterialTheme.colors.surface)
        ) {
            Row(
                modifier = Modifier
                    .wrapContentHeight(align = CenterVertically)
                    .padding(10.dp)
            ) {
                Text(
                    text = "과목명",
                    style = MaterialTheme.typography.h6
                )
            }
            Divider(modifier = Modifier.padding(horizontal = 10.dp), color = Color.Gray)
            FlowRow(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(5.dp)
            ) {
                keyWords.forEach {
                    KeyWord(text = it)
                }
            }
            Row(
                verticalAlignment = CenterVertically,
//            horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
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
//                shape = CircleShape,
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
                        keyWords.add(newText)
                        newText = ""
                        //todo: 유효성 검증
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Outlined.AddCircle,
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
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
//                .background(color = Color.LightGray)
            .padding(horizontal = 5.dp, vertical = 10.dp)
            .border(width = 1.dp, color = Color.LightGray, shape = CircleShape)
            .padding(5.dp)

    ) {
        Text(
            text = text
        )

    }
}

@Composable
fun NoteItem(
    note: Note,
    folded: Boolean = true
) {

}