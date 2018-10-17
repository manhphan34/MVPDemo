package com.example.ma.demomvp.data.repositories;

import com.example.ma.demomvp.data.model.Category;
import com.example.ma.demomvp.data.source.CallBack;
import com.example.ma.demomvp.data.source.RemoteDataSource;
import com.example.ma.demomvp.data.source.categories.CategoryApi;
import com.example.ma.demomvp.screen.categories.JSONKey;

import java.util.ArrayList;

public class CategoryRepository implements RemoteDataSource {

    @Override
    public void getCategoryData(CallBack<ArrayList<Category>> callBack) {
        new CategoryApi(callBack).execute(JSONKey.URL);
    }
}
