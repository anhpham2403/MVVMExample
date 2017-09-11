package com.example.anh.mvvmexample.data.source.local.sqlite;

import android.provider.BaseColumns;

/**
 * Created by anh on 05/09/2017.
 */

public class UserPersistenceContract {
    public UserPersistenceContract() {
    }
    public static class USerEntry implements BaseColumns{
        public static final String TABLE_USERS = "user";
        public static final String ID = "id";
        public static final String USERNAME = "username";
        public static final String PASSWORD = "password";
    }
}
