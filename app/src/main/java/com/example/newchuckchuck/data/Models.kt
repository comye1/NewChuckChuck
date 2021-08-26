package com.example.newchuckchuck.data

import androidx.room.*
import java.text.DateFormat

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true) val noteId: Long = 0L,
    val title: String,
    val days: String
){
    val modifiedDate: String
        get() = DateFormat.getDateTimeInstance().format(System.currentTimeMillis())
}

@Entity(tableName = "keyword_table")
data class Keyword(
    @PrimaryKey(autoGenerate = true) val keywordId: Long = 0L,
    val ownerNoteId: Long,
    val word: String,
    val description: String
)

data class NoteWithKeywords(
    @Embedded val note: Note,
    @Relation(
        parentColumn = "noteId",
        entityColumn = "keywordId"
    )
    val keywords: List<Keyword>
)
