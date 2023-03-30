package com.example.noteappxml.db

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.noteappxml.model.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun getNoteDao(): NoteDao


    companion object{
        @Volatile
        private var INSTANCE: NoteDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(
            LOCK){
            INSTANCE ?: createDatabase(context).also{
                INSTANCE = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
        context.applicationContext, NoteDatabase::class.java,
        "note_database")
        .build()


    }
//    private class NoteDatabaseCallback(private val scope : CoroutineScope) : RoomDatabase.Callback(){
//
//        override fun onCreate(db: SupportSQLiteDatabase) {
//            super.onCreate(db)
//
//            INSTANCE?.let { database ->
//
//                //database.getNoteDao().insert(Note("t","d"))
//
//                scope.launch {
//
//                    val noteDao = database.getNoteDao()
//
//                    noteDao.insertNote(Note("Title 1","Description 1"))
//                    noteDao.insertNote(Note("Title 2","Description 2"))
//                    noteDao.insertNote(Note("Title 3","Description 3"))
//
//                    Log.d("sanka3", "onCreate: ${noteDao.getAllNotes()}")
//
//                }
//
//            }
//
//        }
//
//    }

}
