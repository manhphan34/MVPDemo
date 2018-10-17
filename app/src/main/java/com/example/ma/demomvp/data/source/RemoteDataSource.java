package com.example.ma.demomvp.data.source;


import com.example.ma.demomvp.data.model.Category;
import com.example.ma.demomvp.data.source.CallBack;

import java.util.ArrayList;

public interface RemoteDataSource {
    void getCategory(CallBack<ArrayList<Category>> callback);
}
