package example.com.simpleDatabase

import example.com.model.Note

object NoteDatabase {
    private val notes = mutableListOf<Note>()

    fun getAllNotes(): List<Note> = notes

    fun getNoteById(id: Int): Note? = notes.find { it.id == id }

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun updateNote(updatedNote: Note): Boolean {
        val index = notes.indexOfFirst { it.id == updatedNote.id }
        return if (index != -1) {
            notes[index] = updatedNote
            true
        } else {
            false
        }
    }

    fun deleteNoteById(id: Int): Boolean {
        return notes.removeIf { it.id == id }
    }
}
