package com.example.noteappxml.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.noteappxml.NoteViewModel
import com.example.noteappxml.repository.NoteRepository


class NoteViewModelFactory(private val repository: NoteRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return NoteViewModel(repository) as T

    }
}
