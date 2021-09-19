package com.comye1.keywordnote


import java.util.*

fun getDateString(): String {
    val cal = Calendar.getInstance()
    val year = cal.get(Calendar.YEAR)
    val month = cal.get(Calendar.MONTH) + 1
    val date = cal.get(Calendar.DATE)
    val day = when (cal.get(Calendar.DAY_OF_WEEK)) {

        1 -> "일"
        2 -> "월"
        3 -> "화"
        4 -> "수"
        5 -> "목"
        6 -> "금"
        7 -> "토"
        else -> ""
    }
    return "${year}년 ${month}월 ${date}일 ${day}요일"
}

fun getDateInt(): Int {
    val cal = Calendar.getInstance()
    val year = cal.get(Calendar.YEAR)
    val month = cal.get(Calendar.MONTH) + 1
    val date = cal.get(Calendar.DATE)

    return year * 10000 + month * 100 + date
}