package com.example.noteappxml.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.noteappxml.db.NoteDao
import com.example.noteappxml.db.NoteDatabase
import com.example.noteappxml.model.Note
import kotlinx.coroutines.flow.Flow


class NoteRepository(private val db: NoteDatabase){
    fun getAllNotes() = db.getNoteDao().getAllNotes()

    fun searchNote(query: String) = db.getNoteDao().searchNote(query)

    suspend fun addNote(note: Note) = db.getNoteDao().addNote(note)


    suspend fun updateNote(note: Note)=db.getNoteDao().updateNote(note)


    suspend fun deleteNote(note: Note)= db.getNoteDao().deleteNote(note)



}