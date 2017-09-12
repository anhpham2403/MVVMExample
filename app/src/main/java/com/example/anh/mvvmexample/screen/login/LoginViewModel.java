package com.example.anh.mvvmexample.screen.login;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;
import android.widget.Toast;
import com.example.anh.mvvmexample.data.model.User;
import com.example.anh.mvvmexample.data.source.AuthenicationDataSource;
import com.example.anh.mvvmexample.data.source.AuthenicationReposity;

/**
 * Created by anh on 11/09/2017.
 */

public class LoginViewModel extends BaseObservable {
    private String mUsername;
    private String mPassword;
    private AuthenicationReposity mReposity;
    private Context mContext;

    public LoginViewModel(String username,String password,Context context, AuthenicationReposity reposity) {
        mUsername = username;
        mPassword = password;
        mReposity = reposity;
        mContext = context;
    }

    public View.OnClickListener onClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mReposity.login(mUsername, mPassword, new AuthenicationDataSource.Callback<User>() {
                    @Override
                    public void onSuccess(User data) {
                        Toast.makeText(mContext, "username: " + data.getUsername(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(String msg) {
                        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
                    }
                });
            }
        };
    }
}
