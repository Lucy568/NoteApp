package com.example.demo.database

import com.example.demo.model.Note
import java.util.*

class NoteDatabase {
    var notes = mutableListOf<Note>()
    fun notesData(): MutableList<Note>{

        return notes
    }
    fun createNote(note: Note){
        notes.add(note)
    }
    fun deleteNote(id : String) : MutableList<Note>{
        notes.removeIf {it.id == id }
        return notes



    }
    fun updateNote(editNote: Note) : String {
        val note = notes.find { it.id == editNote.id }
        if (note != null) {
            note.title = editNote.title
        }
        if (note != null) {
            note.body = editNote.body
        }
        return "updated successfully"


    }
}