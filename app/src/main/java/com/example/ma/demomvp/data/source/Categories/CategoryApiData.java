package com.example.ma.demomvp.data.source.Categories;

import android.os.AsyncTask;

import com.example.ma.demomvp.data.model.Category;
import com.example.ma.demomvp.data.source.CallBack;
import com.example.ma.demomvp.screens.categories.CatJSONKey;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CategoryApiData {
    public static String getCategoryJson(String path) {
        String json = "";
        try {
            URL url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(CatJSONKey.METHOD_GET);
            httpURLConnection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String str;
            while ((str = in.readLine()) != null) {
                json = json.concat(str.concat("\n"));
            }
            in.close();
            httpURLConnection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static ArrayList<Category> getCategoryData(String json) {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            JSONArray cats = new JSONArray(new JSONObject(json).getString(CatJSONKey.HD_WALLPAPER));
            for (int i = 0; i < cats.length(); i++) {
                categories.add(new Category(cats.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
