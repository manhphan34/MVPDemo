package com.example.ma.demomvp.screens.login.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ma.demomvp.R;
import com.example.ma.demomvp.screens.login.presenter.LoginPresenterImp;


public class LoginActivity extends AppCompatActivity implements LoginView,View.OnClickListener {
    private EditText mEditUserName, mEditPassWord;
    private ProgressBar mProgressBar;
    private Button mButtonLogin;
    private Context mContext;
    private LoginPresenterImp mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    @Override
    public void showProsesBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProsesBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        Toast.makeText(mContext,getString(R.string.user_name_invalid),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(mContext,getString(R.string.pass_word_invalid),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateCategory() {
        startActivity(new Intent());
    }

    @Override
    public void onClick(View v) {
        showProsesBar();
        mPresenter.authenticateUser(mEditUserName.getText().toString(),mEditPassWord.getText().toString());
    }
    private void initView(){
        mContext = getApplicationContext();
        mButtonLogin = findViewById(R.id.button_login);
        mEditUserName = findViewById(R.id.edit_user_name);
        mEditPassWord = findViewById(R.id.edit_pass_word);
        mProgressBar = findViewById(R.id.progress_main);
        mButtonLogin = findViewById(R.id.button_login);

        mButtonLogin.setOnClickListener(this);

        mPresenter = new LoginPresenterImp(this);
    }
}
