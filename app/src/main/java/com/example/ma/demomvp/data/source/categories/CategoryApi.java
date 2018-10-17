package com.example.ma.demomvp.data.source.categories;

import android.os.AsyncTask;

import com.example.ma.demomvp.data.model.Category;
import com.example.ma.demomvp.data.source.CallBack;

import java.util.ArrayList;

public class CategoryApi extends AsyncTask<String, Void, ArrayList<Category>> {
    private CallBack<ArrayList<Category>> mCallback;
    private Exception mException;

    public CategoryApi(CallBack<ArrayList<Category>> callback) {
        mCallback = callback;
    }

    @Override
    protected ArrayList<Category> doInBackground(String... strings) {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            categories = CategoryData.getCategoryData(CategoryData.getCategoryJson(strings[0]));
        } catch (Exception e) {
            mException = e;
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    protected void onPostExecute(ArrayList<Category> categories) {
        super.onPostExecute(categories);
        if (mException != null) mCallback.getDataError(mException);
        else mCallback.getDataSuccess(categories);
    }
}
