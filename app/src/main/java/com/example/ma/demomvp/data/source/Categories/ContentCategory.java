package com.example.ma.demomvp.data.source.Categories;

import android.os.AsyncTask;

import com.example.ma.demomvp.data.model.Category;
import com.example.ma.demomvp.data.source.CallBack;

import java.util.ArrayList;

public class ContentCategory extends AsyncTask<String, Void, String> {
    private CallBack<ArrayList<Category>> mCallback;

    public ContentCategory(CallBack<ArrayList<Category>> callback) {
        mCallback = callback;
    }

    @Override
    protected String doInBackground(String... strings) {
        return CategoryApiData.getCategoryJson(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mCallback.getDataSuccess(CategoryApiData.getCategoryData(s));
    }
}
