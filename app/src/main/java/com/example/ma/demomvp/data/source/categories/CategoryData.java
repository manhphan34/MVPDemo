package com.example.ma.demomvp.data.source.categories;

import com.example.ma.demomvp.data.model.Category;
import com.example.ma.demomvp.screen.categories.JSONKey;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class CategoryData {
    public static String getCategoryJson(String path) throws Exception {
        String json = "";
        URL url = new URL(path);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(JSONKey.METHOD_GET);
        httpURLConnection.connect();
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String str;
        while ((str = in.readLine()) != null) {
            json = json.concat(str.concat("\n"));
        }
        in.close();
        httpURLConnection.disconnect();
        return json;
    }

    public static ArrayList<Category> getCategoryData(String json) throws Exception {
        ArrayList<Category> categories = new ArrayList<>();
        JSONArray cats = new JSONArray(new JSONObject(json).getString(JSONKey.HD_WALLPAPER));
        for (int i = 0; i < cats.length(); i++) {
            categories.add(new Category(cats.getJSONObject(i)));
        }
        return categories;
    }
}
