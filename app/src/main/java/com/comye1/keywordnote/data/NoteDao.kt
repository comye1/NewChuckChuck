package com.comye1.keywordnote.data

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

    //Update
    @Update suspend fun updateNote(note: Note)

    @Update suspend fun updatePage(page: Page)

    @Update suspend fun updateKeyword(keyword: Keyword)

    //Delete
    @Delete suspend fun deleteNote(note: Note)

    @Delete suspend fun deletePage(page: Page)

    @Delete suspend fun deleteKeyword(keyword: Keyword)

    //Clear
    @Query("DELETE FROM note")
    fun clearNotes()

   //Transaction
    @Query("SELECT * FROM note where noteId = :noteId")
    suspend fun getNoteWithPages(noteId: Int): List<NoteWithPages>

    @Query("SELECT * FROM page where pageId = :pageId")
    suspend fun getPageWithKeywords(pageId: Int): List<PageWithKeywords>

    
}