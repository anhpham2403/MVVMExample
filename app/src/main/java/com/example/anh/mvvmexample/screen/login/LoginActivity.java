package com.example.anh.mvvmexample.screen.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import com.example.anh.mvvmexample.R;
import com.example.anh.mvvmexample.data.model.User;
import com.example.anh.mvvmexample.data.source.AuthenicationReposity;
import com.example.anh.mvvmexample.data.source.local.AuthenicationLocalDataSource;
import com.example.anh.mvvmexample.databinding.ActivityLoginBinding;

/**
 * Created by anh on 11/09/2017.
 */

public class LoginActivity extends AppCompatActivity{
    private LoginViewModel mLoginViewModel;
    private AuthenicationReposity mAuthenicationReposity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuthenicationReposity = new AuthenicationReposity(new AuthenicationLocalDataSource());
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        String username = binding.username.getText().toString();
        String password = binding.password.getText().toString();
        mLoginViewModel = new LoginViewModel(username,password,getApplicationContext(),mAuthenicationReposity);
        binding.setViewModel(mLoginViewModel);
    }
}
