package com.example.anh.mvvmexample.data.source.local;

import com.example.anh.mvvmexample.App;
import com.example.anh.mvvmexample.data.model.User;
import com.example.anh.mvvmexample.data.source.AuthenicationDataSource;
import com.example.anh.mvvmexample.data.source.local.sqlite.UserLocalDataSource;
import java.util.Random;

/**
 * Created by anh on 11/09/2017.
 */

public class AuthenicationLocalDataSource implements AuthenicationDataSource {
    @Override
    public void login(String username, String password, Callback<User> callback) {
        UserLocalDataSource dataSource = UserLocalDataSource.getInstance(App.getContext());
        boolean check =  dataSource.checkUser(username,password);
        if(check){
            callback.onSuccess(new User(new Random().nextLong(),username,password));
        }else {
            callback.onFailure("Login fail");
        }
    }
}
