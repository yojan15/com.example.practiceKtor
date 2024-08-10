package example.com.plugins

import example.com.model.Note
import example.com.simpleDatabase.NoteDatabase
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.*

fun Application.configureRouting() {
    routing {
        // Get all notes
        get("/get") {
            call.respond(NoteDatabase.getAllNotes())
        }

        // Get a note by id
        get("/notes/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null) {
                call.respond(HttpStatusCode.BadRequest, "Invalid ID")
                return@get
            }
            val note = NoteDatabase.getNoteById(id)
            if (note == null) {
                call.respond(HttpStatusCode.NotFound, "Note not found")
            } else {
                call.respond(note)
            }
        }

        // Create a new note
        post("/notes") {
            val note = call.receive<Note>()
            NoteDatabase.addNote(note)
            call.respond(HttpStatusCode.Created, note)
        }

        // Update a note
        put("/notes/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null) {
                call.respond(HttpStatusCode.BadRequest, "Invalid ID")
                return@put
            }
            val updatedNote = call.receive<Note>()
            if (NoteDatabase.updateNote(updatedNote)) {
                call.respond(HttpStatusCode.OK, updatedNote)
            } else {
                call.respond(HttpStatusCode.NotFound, "Note not found")
            }
        }

        // Delete a note by id
        delete("/notes/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null) {
                call.respond(HttpStatusCode.BadRequest, "Invalid ID")
                return@delete
            }
            if (NoteDatabase.deleteNoteById(id)) {
                call.respond(HttpStatusCode.NoContent)
            } else {
                call.respond(HttpStatusCode.NotFound, "Note not found")
            }
        }
    }
}
