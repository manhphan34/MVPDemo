package com.example.ma.demomvp.data.model;

import com.example.ma.demomvp.screen.categories.JSONKey;

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

    public Category(JSONObject jsonObject) throws Exception {
        this.mCatId = jsonObject.getInt(JSONKey.CAT_ID);
        this.mCatName = jsonObject.getString(JSONKey.CAT_NAME);
        this.mCatPathImage = jsonObject.getString(JSONKey.CAT_PATH_IMAGE);
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
