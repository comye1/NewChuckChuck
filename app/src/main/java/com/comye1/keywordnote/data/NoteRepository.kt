package com.comye1.keywordnote.data

interface NoteRepository {
    suspend fun fetchNotes() : List<Note> // 함수 여러개 작성 -> implement해서 override
}