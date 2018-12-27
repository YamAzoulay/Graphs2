package com.example.hp.graphs2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.hp.graphs2.Data.COUNT;
import static com.example.hp.graphs2.Data.DATE;
import static com.example.hp.graphs2.Data.KEY_ID;
import static com.example.hp.graphs2.Data.TABLE_DATA;
import static com.example.hp.graphs2.Data.WEEK;

public class HelperDB extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "dbexam.db";
    private static final int DATABASE_VERSION = 1;

    String strCreate, strDelete;


    public HelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        strCreate="CREATE TABLE "+TABLE_DATA;
        strCreate+=" ("+KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+DATE+" TEXT,";
        strCreate+=" "+WEEK+" INTEGER,";
        strCreate+=" "+COUNT+" INTEGER";
        strCreate+=");";
        db.execSQL(strCreate);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        strDelete="DROP TABLE IF EXISTS "+TABLE_DATA;
        db.execSQL(strDelete);
        onCreate(db);


    }

}
