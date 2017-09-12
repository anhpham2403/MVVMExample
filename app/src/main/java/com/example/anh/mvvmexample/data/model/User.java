package com.example.anh.mvvmexample.data.model;

/**
 * Created by anh on 11/09/2017.
 */

public class User {
    private long mId;
    private String mUsername;
    private String mPassword;

    public User() {
    }

    public User(long id, String username, String password) {
        mId = id;
        mUsername = username;
        mPassword = password;
    }

    public User(String username, String password) {
        mUsername = username;
        mPassword = password;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
