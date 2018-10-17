package com.example.ma.demomvp.screens.login.presenter;

import com.example.ma.demomvp.screens.login.view.LoginView;

public class LoginPresenterImp implements LoginPresenter {
    private LoginView mLoginView;
    public LoginPresenterImp(LoginView loginView){
        mLoginView = loginView;
    }
    @Override
    public void authenticateUser(String userName, String password) {
        if(userName.isEmpty()){
            mLoginView.hideProsesBar();
            mLoginView.setUserNameError();
        }else if(password.isEmpty()){
            mLoginView.hideProsesBar();
            mLoginView.setPasswordError();
        }else mLoginView.navigateCategory();
    }
}
