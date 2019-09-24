package com.dicoding.picodiploma.mynotesapp.helper

import android.database.Cursor
import com.dicoding.picodiploma.mynotesapp.db.DatabaseContract.NoteColumns.Companion.DATE
import com.dicoding.picodiploma.mynotesapp.db.DatabaseContract.NoteColumns.Companion.DESCRIPTION
import com.dicoding.picodiploma.mynotesapp.db.DatabaseContract.NoteColumns.Companion.TITLE
import com.dicoding.picodiploma.mynotesapp.db.DatabaseContract.NoteColumns.Companion._ID

import com.dicoding.picodiploma.mynotesapp.entity.Note

import java.util.ArrayList

object MappingHelper {

    fun mapCursorToArrayList(notesCursor: Cursor): ArrayList<Note> {
        val notesList = ArrayList<Note>()
        notesCursor.moveToFirst()
        while (notesCursor.moveToNext()) {
            val id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(_ID))
            val title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(TITLE))
            val description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DESCRIPTION))
            val date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DATE))
            notesList.add(Note(id, title, description, date))
        }

        return notesList
    }

    fun mapCursorToObject(notesCursor: Cursor): Note {
        var note = Note()

        notesCursor.moveToFirst()

        val id = notesCursor.getInt(notesCursor.getColumnIndexOrThrow(_ID))
        val title = notesCursor.getString(notesCursor.getColumnIndexOrThrow(TITLE))
        val description = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DESCRIPTION))
        val date = notesCursor.getString(notesCursor.getColumnIndexOrThrow(DATE))
        note = Note(id, title, description, date)

        return note
    }
}
