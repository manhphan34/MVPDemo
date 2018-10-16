package com.example.ma.demomvp.screen.login;

public interface LoginContract {
    interface LoginView {
        void showProsesBar();

        void hideProsesBar();

        void onUserNameError();

        void onPasswordError();

        void navigateCategory();
    }

    interface LoginPresenter {
        void authenticateLogin(String userName, String passWord);

        boolean isValidateUser(String userName, String passWord);
    }
}
