package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME="fijosa.db";
    public static final String TABLE_NAME="RegisterUser";
    //column name
    public static final String COL_1="ID";
    public static final String COL_2="FIRSTNAME";
    public static final String COL_3="LASTNAME";
    public static final String COL_4="GENDER";
    public static final String COL_5="DOB";
    public static final String COL_6="COMMENTS";
    public static final String COL_7="TIME";
    public static final String COL_8="STATUS";


    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRSTNAME TEXT,LASTNAME TEXT,GENDER TEXT,DOB VARCHAR,COMMENTS TEXT,TIME DATETIME DEFAULT CURRENT_TIMESTAMP,STATUS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String first_name, String last_name, String gender, String date, String comment)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2,first_name);
        contentValues.put(COL_3,last_name);
        contentValues.put(COL_4,gender);
        contentValues.put(COL_5,date);
        contentValues.put(COL_6,comment);

        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }




}
