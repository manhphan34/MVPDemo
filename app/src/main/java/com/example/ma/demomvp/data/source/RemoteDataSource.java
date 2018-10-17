package com.example.ma.demomvp.data.source;

import com.example.ma.demomvp.data.model.Category;

import java.util.ArrayList;

public interface RemoteDataSource {
    void getCategoryData(CallBack<ArrayList<Category>> callBack);
}
