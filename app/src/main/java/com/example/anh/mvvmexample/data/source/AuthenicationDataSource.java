package com.example.anh.mvvmexample.data.source;

import com.example.anh.mvvmexample.data.model.User;

/**
 * Created by anh on 11/09/2017.
 */

public interface AuthenicationDataSource {
    interface Callback<T>{
        void onSuccess(T  data);
        void onFailure(String msg);
    }
    void login(String username, String password, Callback<User> callback);
}
