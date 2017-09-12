package com.example.anh.mvvmexample.screen.login;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.nfc.Tag;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.anh.mvvmexample.BR;
import com.example.anh.mvvmexample.data.model.User;
import com.example.anh.mvvmexample.data.source.AuthenicationDataSource;
import com.example.anh.mvvmexample.data.source.AuthenicationReposity;

/**
 * Created by anh on 11/09/2017.
 */

public class LoginViewModel extends BaseObservable {
    private final static String TAG = "LoginViewModel";
    private String mUserName;
    private String mPassword;
    private AuthenicationReposity mReposity;
    private Context mContext;

    public LoginViewModel(Context context,
            AuthenicationReposity reposity) {
        mReposity = reposity;
        mContext = context;
    }

    public void onLoginClick() {
        Toast.makeText(mContext, mUserName, Toast.LENGTH_SHORT).show();
    }

    public View.OnClickListener onClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mReposity.login(mUserName, mPassword, new AuthenicationDataSource.Callback<User>() {
                    @Override
                    public void onSuccess(User data) {
                        Toast.makeText(mContext, "username: " + data.getUsername(),
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(String msg) {
                        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
                    }
                });
            }
        };
    }

    @Bindable
    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
        notifyPropertyChanged(BR.password);
    }
}
