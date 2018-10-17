package com.example.ma.demomvp.screen.categories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.ma.demomvp.R;
import com.example.ma.demomvp.data.model.Category;
import com.example.ma.demomvp.data.repositories.CategoryRepository;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements CategoryContract.View {
    private static final int SPAN_COUNT = 2;
    private RecyclerView mRecCategory;
    private CategoryAdapter mAdapter;
    private ArrayList<Category> mCategories;
    private CategoryContract.Presenter mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);
        initComponents();
        loadData();
    }

    @Override
    public void showError(Exception e) {
        Toast.makeText(this,getString(R.string.error_user_load_data),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCategory(ArrayList<Category> categories) {
        mCategories = categories;
        mAdapter.notifyDataSetChanged();
    }
    private void initComponents(){
        mRecCategory = findViewById(R.id.rec_category);
        mCategories= new ArrayList<>();
        mAdapter = new CategoryAdapter(this,mCategories);
        mRecCategory.setLayoutManager(new GridLayoutManager(this,SPAN_COUNT));
        mRecCategory.setAdapter(mAdapter);
    }
    private void loadData(){
        mPresenter = new CategoryPresenter(this);
        mPresenter.getCategoryList(new CategoryRepository());
    }
}
