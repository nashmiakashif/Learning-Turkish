package com.example.project4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "learning.db";
    private static final String CREATE_TBL_Learning = "CREATE TABLE "
            + DatabaseContract.Learning.TABLE_NAME + " ("
            + DatabaseContract.Learning.Category + " TEXT NOT NULL, "
            + DatabaseContract.Learning.E_word + " TEXT NOT NULL, "
            + DatabaseContract.Learning.T_word + " TEXT NOT NULL, "
            + DatabaseContract.Learning.E_Sentence + " TEXT NOT NULL, "
            + DatabaseContract.Learning.T_sentence + " TEXT NOT NULL,"
            + DatabaseContract.Learning.audio + " TEXT NOT NULL)";


    private static final String CREATE_TBL_USER = "CREATE TABLE "
            + DatabaseContract.Users.TABLE_NAME + " ("
            + DatabaseContract.Users.PASSWORD+ " TEXT NOT NULL, "
            + DatabaseContract.Users.EMAIL+ " TEXT NOT NULL, "
            + DatabaseContract.Users.NAME+ " TEXT NOT NULL, "
            + DatabaseContract.Users.AGE+ " INTEGER )";

    private static final String CREATE_TBL_RATE = "CREATE TABLE "
            + DatabaseContract.Rate.TABLE_NAME + " ("
            + DatabaseContract.Rate.EMAIL+ " TEXT NOT NULL, "
            + DatabaseContract.Rate.RATING+ " INTEGER )";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TBL_Learning);
        db.execSQL(CREATE_TBL_USER);
        db.execSQL(CREATE_TBL_RATE);


        // TODO Auto-generated method stub
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }
}

