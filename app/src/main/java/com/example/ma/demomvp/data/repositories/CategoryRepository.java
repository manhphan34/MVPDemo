package com.example.ma.demomvp.data.repositories;

import com.example.ma.demomvp.data.model.Category;
import com.example.ma.demomvp.data.source.CallBack;
import com.example.ma.demomvp.data.source.Categories.CategoryApiData;
import com.example.ma.demomvp.data.source.RemoteDataSource;
import com.example.ma.demomvp.screens.categories.CatJSONKey;

import java.util.ArrayList;

public class CategoryRepository implements RemoteDataSource {
    private static CategoryRepository mInstance;
    public static CategoryRepository getInstance(){
        if(mInstance == null) mInstance = new CategoryRepository();
        return mInstance;
    }
    @Override
    public void getCategory(CallBack<ArrayList<Category>> callback) {
        new CategoryApiData.ContentCategory(callback).execute(CatJSONKey.URL);
    }
}
