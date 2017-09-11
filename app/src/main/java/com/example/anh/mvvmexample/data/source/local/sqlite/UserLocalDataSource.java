package com.example.anh.mvvmexample.data.source.local.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by anh on 09/09/2017.
 */

public class UserLocalDataSource extends UserDatabaseHelper {
    private static UserLocalDataSource dataSource;

    public UserLocalDataSource(Context context) {
        super(context);
    }

    public static UserLocalDataSource getInstance(Context context) {
        if (dataSource == null) {
            dataSource = new UserLocalDataSource(context);
        }
        return dataSource;
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + UserPersistenceContract.USerEntry.TABLE_USERS +
                " WHERE " + UserPersistenceContract.USerEntry.USERNAME + " =? " + " AND " + UserPersistenceContract.USerEntry.PASSWORD + " =?";
        Cursor cursor = db.rawQuery(sql, new String[]{username, password});
        if (cursor.getCount()==0){
            db.close();
            return false;
        }
        db.close();
        return true;
    }
}