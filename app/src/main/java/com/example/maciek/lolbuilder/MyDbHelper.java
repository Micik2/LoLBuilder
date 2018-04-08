package com.example.maciek.lolbuilder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Maciek on 2017-06-25.
 */

public class MyDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "lolbuilder2.db";

    public final String TABLE_CREATE = "CREATE TABLE Skills(" +
            "ChampionName TEXT, " +
            "ChampionId INT, " +
            "Q TEXT, " +
            "W TEXT, " +
            "E TEXT, " +
            "R TEXT, " +
            "CostQ INT, " +
            "CostW INT, " +
            "CostE INT, " +
            "CostR INT, " +
            "DamageQ INT, " +
            "DamageW INT, " +
            "DamageE INT, " +
            "DamageR INT, " +
            "ConverterQ FLOAT, " +
            "ConverterW FLOAT, " +
            "ConverterE FLOAT, " +
            "ConverterR FLOAT, " +
            "ConverterType VARCHAR(2));";
    public final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS Skills";

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }
    }
}
