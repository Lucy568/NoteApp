package com.example.demo.database

import com.example.demo.model.Note
import java.util.*

class NoteDatabase {
    var notes = mutableListOf<Note>()
    var note1 = Note()
    var note2 = Note()

    init {
        note1.id = "1"
        note1.title = "Note"
        note1.body = "chicken"
        note1.image = "tea"
        note1.time = "Fri Jun 19 13:12:45 WAT 2020"

        note2.id = "2"
        note2.title = "Note2"
        note2.body = "chicken2"
        note2.image = "tea2"
        note2.time = "Fri Jun 19 13:12:45 WAT 2020"
        notes.add(note1)
        notes.add(note2)
    }

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