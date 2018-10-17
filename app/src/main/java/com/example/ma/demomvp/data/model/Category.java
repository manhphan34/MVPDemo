package com.example.ma.demomvp.data.model;


import com.example.ma.demomvp.screens.categories.CatJSONKey;

import org.json.JSONException;
import org.json.JSONObject;

public class Category {
    private int mCatId;
    private String mCatName;
    private String mCatPathImage;

    public Category(int mCatId, String mCatName, String mCatPathImage) {
        this.mCatId = mCatId;
        this.mCatName = mCatName;
        this.mCatPathImage = mCatPathImage;
    }


    public Category(JSONObject jsonObject) {
        try {
            this.mCatId = jsonObject.getInt(CatJSONKey.CAT_ID);
            this.mCatName = jsonObject.getString(CatJSONKey.CAT_NAME);
            this.mCatPathImage = jsonObject.getString(CatJSONKey.CAT_PATH_IMAGE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getmCatId() {
        return mCatId;
    }

    public void setmCatId(int mCatId) {
        this.mCatId = mCatId;
    }

    public String getmCatName() {
        return mCatName;
    }

    public void setmCatName(String mCatName) {
        this.mCatName = mCatName;
    }

    public String getmCatPathImage() {
        return mCatPathImage;
    }

    public void setmCatPathImage(String mCatPathImage) {
        this.mCatPathImage = mCatPathImage;
    }
}
