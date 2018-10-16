package com.example.ma.demomvp.data.source.Category;


import com.example.ma.demomvp.data.model.CategoryImage;
import com.example.ma.demomvp.data.source.CallBack;

import java.util.ArrayList;

public interface RemoteDataSource {
    void getCategory(CallBack<ArrayList<CategoryImage>> callback);
}
