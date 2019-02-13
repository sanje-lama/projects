package com.example.stl.sqlfromscratch.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.stl.sqlfromscratch.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="MyTexts.db";
    private static final String TABLE_NAME="texts";
    private static final int SCHEMA_VERSION=1;
    private static NoteDatabase ourInstance;

    public NoteDatabase(Context context) {
        super(context, DATABASE_NAME,null,SCHEMA_VERSION);
    }

    public static synchronized NoteDatabase getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new NoteDatabase(context.getApplicationContext());
        }
        return ourInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE "+TABLE_NAME+" (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + " name TEXT , message TEXT );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addNote(Note note) {
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE name = '" + note.getName() +
                        "' AND message = '" + note.getMessage() + "';", null);
        if (cursor.getCount() == 0) {
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(name, message) VALUES('" +
                    note.getName() + "', '" +
                    note.getMessage() + "');");
        }
        cursor.close(); //could cause a memory leak if this method is not used.
    }

    public List<Note> getNoteList() {
        List<Note> noteList = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Note note = new Note(
                            cursor.getString(cursor.getColumnIndex("name")),
                            cursor.getString(cursor.getColumnIndex("message")));
                    noteList.add(note);
                } while (cursor.moveToNext());
            }
        }
        return noteList;
    }
}



