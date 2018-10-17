package com.example.ma.demomvp.screen.login;


public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mLoginView;

    public LoginPresenter(LoginContract.View loginView) {
        mLoginView = loginView;
    }

    @Override
    public void authenticateLogin(String userName, String passWord) {
        if (isValidateUser(userName, passWord)) {
            navigate();
        } else hideProsesBar();
    }

    @Override
    public boolean isValidateUser(String userName, String passWord) {
        if (userName.isEmpty()) {
            mLoginView.onUserNameError();
            return false;
        }
        if (passWord.isEmpty()) {
            mLoginView.onPasswordError();
            return false;
        }
        return true;
    }

    private void navigate() {
        mLoginView.navigateCategory();
    }

    private void hideProsesBar() {
        mLoginView.hideProsesBar();
    }

}
