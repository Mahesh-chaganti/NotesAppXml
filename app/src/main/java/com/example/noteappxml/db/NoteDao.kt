package com.example.noteappxml.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteappxml.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    @Query("SELECT * from Note order by id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Query("SELECT * from Note where title LIKE :query or content LIKE :query or date LIKE :query")
    fun searchNote(query: String): LiveData<List<Note>>

    @Delete
    suspend fun deleteNote(note: Note)


    @Update
    suspend fun updateNote(note: Note)

}