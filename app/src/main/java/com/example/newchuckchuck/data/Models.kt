package com.example.newchuckchuck.data

import androidx.room.*
import java.text.DateFormat

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) val noteId: Int? = 0,
    val noteTitle: String?,
    val days: String?,
    val updatedAt: Long? // Note 정렬 용도
)

@Entity
data class Page(
    @PrimaryKey(autoGenerate = true) val pageId: Int? = 0,
    val pageTitle: String?,
    val createdAt: Int?,
    val byTT: Boolean? = false
)

data class NoteWithPages(
    @Embedded val note: Note?,
    @Relation(
        parentColumn = "noteId",
        entityColumn = "pageId"
    )
    val keywords: List<Page?>
)

@Entity
data class Keyword(
    @PrimaryKey(autoGenerate = true) val keywordId: Int? = 0,
    val ownerNoteId: Int?,
    val word: String?,
    val description: String?
)

data class PageWithKeywords(
    @Embedded val note: Note?,
    @Relation(
        parentColumn = "pageId",
        entityColumn = "keywordId"
    )
    val keywords: List<Keyword?>
)

data class KeywordImage(
    @PrimaryKey val imgNameId: Int? = 0,
    val ownerKeywordId: Int?
)

data class KeywordWithImages(
    @Embedded val keyword:Keyword?,
    @Relation(
        parentColumn = "keywordId",
        entityColumn = "imgNameId"
    )
    val keywordImages: List<KeywordImage?>
)