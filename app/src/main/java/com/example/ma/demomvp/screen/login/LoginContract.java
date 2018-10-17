package com.example.ma.demomvp.screen.login;

public interface LoginContract {
    interface View {
        void showProsesBar();

        void hideProsesBar();

        void onUserNameError();

        void onPasswordError();

        void navigateCategory();
    }

    interface Presenter {
        void authenticateLogin(String userName, String passWord);

        boolean isValidateUser(String userName, String passWord);
    }
}
