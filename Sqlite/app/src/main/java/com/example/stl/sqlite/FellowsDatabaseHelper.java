package com.example.stl.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class FellowsDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "fellows.db";
    private static final String TABLE_NAME = "fellows";
    private static final int SCHEMA_VERSION = 1;

    public FellowsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                        " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "last_name TEXT, first_name TEXT, company TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        /*  Important for when you update an entire database with a new version.
         *   We won't be exploring that in this lecture's example.
         */
    }

    public void addFellow(Fellow fellow) {
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE first_name = '" + fellow.getFirstName() +
                        "' AND last_name = '" + fellow.getLastName() + "' AND company = '" + fellow.getCompany() +
                        "';", null);
        if (cursor.getCount() == 0) {
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    "(last_name, first_name, company) VALUES('" +
                    fellow.getLastName() + "', '" +
                    fellow.getFirstName() + "', '" +
                    fellow.getCompany() + "');");
        }
        cursor.close();
    }

    public List<Fellow> getFellowList() {
        List<Fellow> fellowList = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + ";", null);
        if(cursor != null) {
            if(cursor.moveToFirst()) {
                do {
                    Fellow fellow = new Fellow(
                            cursor.getString(cursor.getColumnIndex("last_name")),
                            cursor.getString(cursor.getColumnIndex("first_name")),
                            cursor.getString(cursor.getColumnIndex("company")));
                    fellowList.add(fellow);
                } while (cursor.moveToNext());
            }
        }
        return fellowList;
    }
}






//
//    private static final String DATABASE_NAME = "fellow.db";
//    private static final String TABLE_NAME = "fellow";
//    private static final int SCHEMA_VERSION = 1;
//
//
//    public FellowsDatabaseHelper(@NonNull Context context) {
//        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
//    }
//
//
//
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//
//        db.execSQL(
//                "CREATE TABLE " + TABLE_NAME +
//                        " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                        "last_name TEXT, first_name TEXT, company TEXT);");
//
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//    }
//
//    public void addFellow(@NonNull Fellow fellow) {
//        // Retrieve all entries with the same values as the fellow we are adding.
//
//        Cursor cursor = getReadableDatabase().rawQuery(
//                "SELECT * FROM " + TABLE_NAME + " WHERE first_name = '" + fellow.getFirstName() +
//                        "' AND last_name = '" + fellow.getLastName() + "' AND company = '" + fellow.getCompany() +
//                        "';", null);
//
//        // If there are no fellow iwth the same exact fields, then add them to the database.
//        if (cursor.getCount() == 0) {
//            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
//                    "(last_name, first_name, company) VALUES('" +
//                    fellow.getLastName() + "', '" +
//                    fellow.getFirstName() + "', '" +
//                    fellow.getCompany() + "');");
//        }
//        cursor.close();
//    }
//
//
//
//
//    public List<Fellow> getFellowList() {
//
//        // Get all entries in our database
//        List<Fellow> fellowList = new ArrayList<>();
//        Cursor cursor = getReadableDatabase().rawQuery(
//                "SELECT * FROM " + TABLE_NAME + ";", null);
//
//        // If there are actual entres
//        if (cursor != null) {
//
//        // Start at the top of the database.
//            if (cursor.moveToFirst()) {
//                do {
//                    Fellow fellow = new Fellow(
//                            cursor.getString(cursor.getColumnIndex("last_name")),
//                            cursor.getString(cursor.getColumnIndex("first_name")),
//                            cursor.getString(cursor.getColumnIndex("company")),
//
//        // Add this new fellow instance to our list
//                    fellowList.add(fellow);
//        // While there are more fellow entries to get, keep looping.
//                } while (cursor.moveToNext());
//            }
//        }
//        // return a new list of fellows.
//        return fellowList;



