package com.example.ma.demomvp.screen.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ma.demomvp.R;
import com.example.ma.demomvp.screen.categories.CategoryActivity;


public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener {
    private EditText mEditUserName, mEditPassWord;
    private ProgressBar mProgressBar;
    private LoginContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    @Override
    public void onClick(View v) {
        showProsesBar();
        mPresenter = new LoginPresenter(this);
        mPresenter.authenticateLogin(mEditUserName.getText().toString(), mEditPassWord.getText().toString());
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
    public void onUserNameError() {
        Toast.makeText(this, getString(R.string.error_user_name_invalid), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPasswordError() {
        Toast.makeText(this, getString(R.string.error_pass_word_invalid), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateCategory() {
        startActivity(new Intent(this, CategoryActivity.class));
    }

    private void initViews() {
        mEditUserName = findViewById(R.id.edit_user_name);
        mEditPassWord = findViewById(R.id.edit_pass_word);
        mProgressBar = findViewById(R.id.progress_main);
        findViewById(R.id.button_login).setOnClickListener(this);
    }
}
