package com.example.ma.demomvp.screen.category.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ma.demomvp.R;
import com.example.ma.demomvp.data.model.CategoryImage;
import com.example.ma.demomvp.data.repository.HomeRepository;
import com.example.ma.demomvp.screen.Category.Presenter.CategoryPreImp;

import java.util.ArrayList;

public class Category extends AppCompatActivity implements CategoryView{
    private RecyclerView mRecCategory;
    private CategoryPreImp mCatPresenter;
    private ArrayList<CategoryImage> mCategoryImages;
    private RecyclerView.LayoutManager mLayoutManager;
    private CategoryAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();
        loadData();
    }
    @Override
    public void showCategory(ArrayList<CategoryImage> data) {
        mCategoryImages = data;
        mAdapter.notifyDataSetChanged();
    }
    private void initViews(){
        mRecCategory =findViewById(R.id.rec_category_image);
        mCatPresenter = new CategoryPreImp(this);
        mCategoryImages = new ArrayList<>();
        mLayoutManager = new GridLayoutManager(this,2);
        mRecCategory.setLayoutManager(mLayoutManager);
        mAdapter = new CategoryAdapter(this, mCategoryImages);
        mRecCategory.setAdapter(mAdapter);
    }
    private void loadData(){
        mCatPresenter.getCategoryList(HomeRepository.getInstance());
    }
}
