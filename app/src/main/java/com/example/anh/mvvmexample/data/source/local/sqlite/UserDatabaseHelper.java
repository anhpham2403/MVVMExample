package com.example.anh.mvvmexample.data.source.local.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by anh on 04/09/2017.
 */

public class UserDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "test";

    public UserDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + UserPersistenceContract.USerEntry.TABLE_USERS + " (" + UserPersistenceContract.USerEntry.ID
                + " INTEGER PRIMARY KEY," + UserPersistenceContract.USerEntry.USERNAME + " TEXT," + UserPersistenceContract.USerEntry.PASSWORD
                + " TEXT" + " )";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UserPersistenceContract.USerEntry.TABLE_USERS);
        onCreate(sqLiteDatabase);
    }

}
