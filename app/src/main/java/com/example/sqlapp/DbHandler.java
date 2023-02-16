package com.example.sqlapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper {
    //Creating Variables to pass to the arguments
    public static final int VERSION=1;
    public static final String DB_NAME="ToDo";
    public static final String TABLE_NAME= "ToDoList";

    // Column names
    private static final String ID ="id";
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String STARTED = "started " ;
    private static final String FINISHED ="finished";

    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);     //Passing above created variables
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //CREATE TABLE todo (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, descrip tion TEXT,started TEXT, finished TEXT);
        String TABLE_CREATE_QUERY = "CREATE TABLE "+ TABLE_NAME+" "+
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +TITLE + " TEXT,"
                +DESCRIPTION+" TEXT,"
                +STARTED+" TEXT,"
                +FINISHED+" TEXT"+
        ");";
        //Executing the query
        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       /* If we change something (EX-Column name or something) we have to change thee version number if the version
         number is differ on upgrade methode will run and re create the table */

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME;  // Drop older table if existed
        db.execSQL ( DROP_TABLE_QUERY);     //Create tables again
        onCreate (db) ;
    }
}
