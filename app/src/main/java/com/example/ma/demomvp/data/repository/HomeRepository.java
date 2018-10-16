package com.example.ma.demomvp.data.repository;

import com.example.ma.demomvp.data.model.CategoryImage;
import com.example.ma.demomvp.data.source.CallBack;
import com.example.ma.demomvp.data.source.Category.FetchDataFromApi;
import com.example.ma.demomvp.data.source.Category.RemoteDataSource;
import com.example.ma.demomvp.myclass.MyKey;

import java.util.ArrayList;

public class HomeRepository implements RemoteDataSource {
    private static HomeRepository mInstance;
    public static HomeRepository getInstance(){
        if(mInstance == null) mInstance = new HomeRepository();
        return mInstance;
    }
    @Override
    public void getCategory(CallBack<ArrayList<CategoryImage>> callback) {
        new FetchDataFromApi.ContentCategory(callback).execute(MyKey.URL);
    }
}
