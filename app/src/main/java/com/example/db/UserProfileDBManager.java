package com.example.db;

/**
 * Created by rifathi on 9/6/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserProfileDBManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "dealer.db";
    private static final int DATABSE_VERSION = 1;
    public static final String TABLE_USERPROFILE = "userprofile";
    public static final String COLUMN_ID = "userid";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_LASTNAME = "lastname";

    private static final String CREATE_TABLE_SQL =
            "CREATE TABLE " + TABLE_USERPROFILE + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_USERNAME + " TEXT, " +
            COLUMN_PASSWORD + " TEXT, " +
            COLUMN_FIRSTNAME + " TEXT, " +
            COLUMN_LASTNAME + " TEXT, " +
            ")";

    public UserProfileDBManager (Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USERPROFILE);
        db.execSQL(CREATE_TABLE_SQL);
    }
}
