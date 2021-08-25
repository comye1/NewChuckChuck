package com.example.newchuckchuck.screens.home

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.newchuckchuck.getDateString
import com.example.newchuckchuck.ui.theme.DeepGreen
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun HomeScreen() {
    // todo : 태블릿 위한 레이아웃 어떻게 ??
    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = "Home screen 뭐라고 쓸까~~", style = MaterialTheme.typography.h5)
        Text(text = getDateString(), style = MaterialTheme.typography.body2)
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

@Composable
fun SubjectSection() {

    var newText by remember {
        mutableStateOf("")
    }

    var keyWords = remember {
        mutableStateListOf("키움", "기아", "삼성", "롯데")
    }


    Card(elevation = 10.dp, shape = RoundedCornerShape(15.dp)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .fillMaxWidth()
                    .wrapContentHeight(align = CenterVertically)
                    .padding(10.dp)
            ) {
                Text(text = "과목명", style = MaterialTheme.typography.subtitle1)
            }
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
                modifier = Modifier.padding(10.dp)
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

@Composable
fun KeyWord(text: String) {
    Surface(modifier = Modifier.padding(5.dp), shape = CircleShape) {
        Text(
            text = text,
            Modifier
//                .background(color = Color.LightGray)
                .border(width = 1.dp, color = DeepGreen, shape = CircleShape)
                .padding(horizontal = 10.dp, vertical = 5.dp)
        )
    }
}

