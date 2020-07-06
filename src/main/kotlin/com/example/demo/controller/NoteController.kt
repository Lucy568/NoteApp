package com.example.demo.controller

import com.example.demo.database.NoteDatabase
import com.example.demo.model.DeleteNoteRequest
import com.example.demo.model.Note
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*
import java.rmi.activation.ActivationGroupID
import java.util.*

@RestController
@CrossOrigin(origins = arrayOf("*"))
class NoteController {
    val noteDatabase : NoteDatabase = NoteDatabase()
        @PostMapping("/listnotes")
        fun listNotes(): MutableList<Note>{

            return noteDatabase.notesData()
        }

    @CrossOrigin(origins = arrayOf("*"))
    @PostMapping("/create")
    fun createNote(@RequestBody note: Note): Note {
        noteDatabase.createNote(note)
        return note
    }
    @CrossOrigin(origins = arrayOf("*"))
    @PostMapping("/delete")
    fun deleteNote( @RequestBody deleteNoteRequest: DeleteNoteRequest):MutableList<Note> {
       return noteDatabase.deleteNote(deleteNoteRequest.id)
    }
    @CrossOrigin(origins = arrayOf("*"))
    @PostMapping("/update")
    fun updateNote( @RequestBody note: Note): String {
        return noteDatabase.updateNote(editNote = note)
    }
}
