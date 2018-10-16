package com.example.ma.demomvp.screens.categories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ma.demomvp.R;
import com.example.ma.demomvp.data.model.Category;
import com.example.ma.demomvp.data.repositories.CategoryRepository;


import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements CategoryContract.CategoryView {
    private RecyclerView mRecCategory;
    private CategoryPreImp mCatPresenter;
    private ArrayList<Category> mCategories;
    private RecyclerView.LayoutManager mLayoutManager;
    private CategoryAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();
        loadData();
    }
    @Override
    public void showCategory(ArrayList<Category> data) {
        mCategories = data;
        mAdapter.notifyDataSetChanged();
    }
    private void initViews(){
        mRecCategory =findViewById(R.id.rec_category_image);
        mCatPresenter = new CategoryPreImp(this);
        mCategories = new ArrayList<>();
        mLayoutManager = new GridLayoutManager(this,2);
        mRecCategory.setLayoutManager(mLayoutManager);
        mAdapter = new CategoryAdapter(this, mCategories);
        mRecCategory.setAdapter(mAdapter);
    }
    private void loadData(){
        mCatPresenter.getCategoryList(CategoryRepository.getInstance());
    }
}
