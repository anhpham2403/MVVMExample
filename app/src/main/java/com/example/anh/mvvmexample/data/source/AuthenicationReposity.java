package com.example.anh.mvvmexample.data.source;

import com.example.anh.mvvmexample.data.model.User;
import com.example.anh.mvvmexample.data.source.local.AuthenicationLocalDataSource;

/**
 * Created by anh on 11/09/2017.
 */

public class AuthenicationReposity implements AuthenicationDataSource {
    private AuthenicationLocalDataSource mLocalDataSource;

    public AuthenicationReposity(AuthenicationLocalDataSource localDataSource) {
        mLocalDataSource = localDataSource;
    }

    @Override
    public void login(String username, String password, Callback<User> callback) {
        mLocalDataSource.login(username,password,callback);
    }
}
