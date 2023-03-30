package com.example.noteappxml.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteappxml.NoteApplication
import com.example.noteappxml.NoteViewModel
import com.example.noteappxml.R
import com.example.noteappxml.databinding.ActivityMainBinding
import com.example.noteappxml.db.NoteDatabase
import com.example.noteappxml.repository.NoteRepository
import com.example.noteappxml.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {





    lateinit var noteViewModel : NoteViewModel
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        try{
            setContentView(mainBinding.root)
            val noteRepository = NoteRepository(NoteDatabase(this))
            val activityNoteViewModelFactory = NoteViewModelFactory(noteRepository)
            noteViewModel = ViewModelProvider(this, activityNoteViewModelFactory)[NoteViewModel::class.java]

        }catch(e: Exception){
            Log.d("TAG", "onCreate: $e")
        }


        //val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        val noteAdapter = NoteAdapter(this)
//        recyclerView.adapter = noteAdapter

        //register activity for result


      //  val viewModelFactory = NoteViewModelFactory((application as NoteApplication).repository)

       // noteViewModel = ViewModelProvider(this, viewModelFactory).get(NoteViewModel::class.java)


//        noteViewModel.allMyNotes.observe(this, Observer { notes ->
//
//            //update UI
//            noteAdapter.setNote(notes)
//
//        })
    }
}