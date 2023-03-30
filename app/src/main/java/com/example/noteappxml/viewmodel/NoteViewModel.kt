package com.example.noteappxml

import androidx.lifecycle.*
import com.example.noteappxml.model.Note
import com.example.noteappxml.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(private val noteRepository: NoteRepository): ViewModel() {

    fun allMyNotes() : LiveData<List<Note>> = noteRepository.getAllNotes()

    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.addNote(note)
    }

    fun deleteNote(note: Note)= viewModelScope.launch(Dispatchers.IO){
        noteRepository.deleteNote(note)
    }
    fun updateNote(note: Note) = viewModelScope.launch(Dispatchers.IO){
        noteRepository.updateNote(note)
    }
    fun searchNote(query: String): LiveData<List<Note>> = noteRepository.searchNote(query)


}

