package com.example.ma.demomvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;


import com.example.ma.demomvp.myclass.MyKey;

import org.json.JSONException;
import org.json.JSONObject;

public class CategoryImage  {
    private int mCatId;
    private String mCatName;
    private String mCatPathImage;

    public CategoryImage(int mCatId, String mCatName, String mCatPathImage) {
        this.mCatId = mCatId;
        this.mCatName = mCatName;
        this.mCatPathImage = mCatPathImage;
    }

    public CategoryImage(JSONObject jsonObject){
        try {
            this.mCatId = jsonObject.getInt(MyKey.CAT_ID);
            this.mCatName = jsonObject.getString(MyKey.CAT_NAME);
            this.mCatPathImage = jsonObject.getString(MyKey.CAT_PATH_IMAGE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getCatId() {
        return mCatId;
    }

    public void setCatId(int mCatId) {
        this.mCatId = mCatId;
    }

    public String getCatName() {
        return mCatName;
    }

    public void setCatName(String mCatName) {
        this.mCatName = mCatName;
    }

    public String getCatPathImage() {
        return mCatPathImage;
    }

    public void setCatPathImage(String mCatPathImage) {
        this.mCatPathImage = mCatPathImage;
    }
}
