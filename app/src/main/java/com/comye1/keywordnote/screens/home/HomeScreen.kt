package com.comye1.keywordnote.screens.home

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
import androidx.compose.material.icons.outlined.AddBox
import androidx.compose.material.icons.outlined.Image
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.comye1.keywordnote.getDateString
import com.comye1.keywordnote.ui.theme.DeepGreen
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "바로 기록하기")
                    Text(
                        text = getDateString(),
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            },
            backgroundColor = Color.White,
            elevation = 0.dp,
        )
    }) {

        LazyColumn(modifier = Modifier.padding(8.dp)) {
            repeat(10) {
                item {
                    NoteItem()
                }
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                }
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


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                BorderStroke(
                    width = 2.dp,
                    color = Color.LightGray
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(vertical = 8.dp, horizontal = 12.dp),
//                .border(width = 3.dp, Color.LightGray)
//                .padding(vertical = 8.dp, horizontal = 12.dp)
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
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.ExtraBold,
                color = Color.DarkGray
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Label,
                tint = Color.DarkGray,
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "소제목입니다 키움 너무못해",
                style = MaterialTheme.typography.subtitle1,
                color = Color.DarkGray
            )
        }
        Spacer(modifier = Modifier.height(2.dp))
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        ) {
            TextField(
                value = newText,
                onValueChange = { newText = it },
                placeholder = { Text(text = "키워드") },
                textStyle = MaterialTheme.typography.body1,
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = DeepGreen,
                    unfocusedIndicatorColor = Color.LightGray,
                    cursorColor = DeepGreen,
                    backgroundColor = Color.Transparent
                ),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyWords.add(newText)
                        newText = ""
                    }
                ),
                modifier = Modifier.weight(9f)
            )
            IconButton(
                onClick = {
                    // 뷰모델 addNewKeyword 호출
                    keyWords.add(newText)
                    newText = ""
                    //todo: 유효성 검증
                },
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight(),
            ) {
                Icon(
                    imageVector = Icons.Outlined.Image,
                    contentDescription = "add",
                    modifier = Modifier
                        .fillMaxSize(),
                    tint = Color.Gray
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            IconButton(
                onClick = {
                    // 뷰모델 addNewKeyword 호출
                    keyWords.add(newText)
                    newText = ""
                    //todo: 유효성 검증
                },
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight(),
            ) {
                Icon(
                    imageVector = Icons.Outlined.AddBox,
                    contentDescription = "add",
                    modifier = Modifier
                        .fillMaxSize(),
                    tint = Color.Gray
                )
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
            .padding(vertical = 4.dp)

    ) {
        Text(
            text = text,
            modifier = Modifier
                .border(width = 1.5.dp, color = Color.LightGray, shape = CircleShape)
                .padding(vertical = 6.dp, horizontal = 8.dp),
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.width(4.dp))
    }
}
