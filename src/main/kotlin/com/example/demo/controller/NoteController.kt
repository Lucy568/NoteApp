package com.example.demo.controller

import com.example.demo.database.NoteDatabase
import com.example.demo.model.DeleteNoteRequest
import com.example.demo.model.Note
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.rmi.activation.ActivationGroupID
import java.util.*

@RestController
class NoteController {
    val noteDatabase : NoteDatabase = NoteDatabase()
        @GetMapping("/listnotes")
        fun listNotes(): MutableList<Note>{

            return noteDatabase.notesData()
        }


    @GetMapping("/create")
    fun createNote(@RequestBody note: Note): Note {
        noteDatabase.createNote(note)
        return note
    }

    @GetMapping("/delete")
    fun deleteNote( @RequestBody deleteNoteRequest: DeleteNoteRequest):MutableList<Note> {
       return noteDatabase.deleteNote(deleteNoteRequest.id)
    }

    @PostMapping("/update")
    fun updateNote( @RequestBody note: Note): String {
        return noteDatabase.updateNote(editNote = note)
    }
}
