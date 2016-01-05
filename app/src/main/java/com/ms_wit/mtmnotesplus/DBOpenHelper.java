package com.ms_wit.mtmnotesplus;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by firelf on 12/20/15.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    //Constants for db name and version
    private static final String DATABASE_NAME = "notes.db";
    private static final int DATABASE_VERSION = 2;

    // Table Names
    public static final String TABLE_CONTENTS = "contents";
    public static final String TABLE_NOTES = "notes";

    // CONTENTS Table - column names
    public static final String CONTENT_ID = "content_id";
    public static final String CONTENT_TITLE = "content_title";
    public static final String CONTENT_PICTURE = "content_picture";
    public static final String CONTENT_PARAGRAPH = "content_paragraph";
    public static final String[] ALL_COLUMNS_CONTENTS = {CONTENT_ID, CONTENT_TITLE, CONTENT_PICTURE, CONTENT_PARAGRAPH};

    // NOTES Table - column names
    public static final String NOTE_ID = "_id";
    public static final String NOTE_TEXT = "noteText";
    public static final String NOTE_CREATED = "noteCreated";
    public static final String RELATED_CONTENT_ID = "related_content_id";
    public static final String[] ALL_COLUMNS = {NOTE_ID, NOTE_TEXT, NOTE_CREATED, RELATED_CONTENT_ID};

    // CONTENTS Table Create Statements
    private static final String CREATE_TABLE_CONTENTS =
            "CREATE TABLE " + TABLE_CONTENTS + "(" +
                    CONTENT_ID + " INTEGER PRIMARY KEY," +
                    CONTENT_TITLE + " TEXT," +
                    CONTENT_PICTURE + " PICTURE BLOB" +
                    CONTENT_PARAGRAPH + " TEXT" + ")";

    // NOTES Table Create Statement
    private static final String CREATE_TABLE_NOTES =
            "CREATE TABLE " + TABLE_NOTES + " (" +
                    NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NOTE_TEXT + " TEXT, " +
                    RELATED_CONTENT_ID + " INTEGER, " + NOTE_CREATED + " TEXT default CURRENT_TIMESTAMP" + ")";

    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTENTS);
        db.execSQL(CREATE_TABLE_NOTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(db);
    }
}
