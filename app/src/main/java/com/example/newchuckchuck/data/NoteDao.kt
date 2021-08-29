package com.example.newchuckchuck.data

import android.icu.text.AlphabeticIndex
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getNotes(): LiveData<List<Note>>

    //Insert
    @Insert suspend fun insertNote(note: Note)

    @Insert suspend fun insertPage(page: Page)

    @Insert suspend fun insertKeyword(keyword: Keyword)

    @Insert suspend fun insertImage(image: KeywordImage)

    //Update
    @Update suspend fun updateNote(note: Note)

    @Update suspend fun updatePage(page: Page)

    @Update suspend fun updateKeyword(keyword: Keyword)

    //Delete
    @Delete suspend fun deleteNote(note: Note)

    @Delete suspend fun deletePage(page: Page)

    @Delete suspend fun deleteKeyword(keyword: Keyword)

    @Delete suspend fun deleteKeywordImage(image: KeywordImage)

    //Clear
    @Query("DELETE FROM note")
    fun clearNotes()

   //Transaction
    @Query("SELECT * FROM note where noteId = :noteId")
    suspend fun getNoteWithPages(noteId: Int): List<NoteWithPages>

    @Query("SELECT * FROM page where pageId = :pageId")
    suspend fun getPageWithKeywords(pageId: Int): List<PageWithKeywords>

    @Query("SELECT * FROM keyword where keywordId =:keywordId")
    suspend fun getKeywordWithImages(keywordId: Int): List<KeywordWithImages>
    
}