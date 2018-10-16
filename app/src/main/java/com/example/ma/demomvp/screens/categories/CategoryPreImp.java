package com.example.ma.demomvp.screens.categories;

import com.example.ma.demomvp.data.model.Category;
import com.example.ma.demomvp.data.repositories.CategoryRepository;
import com.example.ma.demomvp.data.source.CallBack;

import java.util.ArrayList;

public class CategoryPreImp implements CategoryContract.CategoryPresenter {
    private CategoryContract.CategoryView mCategory;
    public CategoryPreImp(CategoryContract.CategoryView categoryView){
        this.mCategory = categoryView;
    }
    @Override
    public void getCategoryList(CategoryRepository categoryRepository) {
        categoryRepository.getCategory(new CallBack<ArrayList<Category>>() {
            @Override
            public void getDataSuccess(ArrayList<Category> data) {
                mCategory.showCategory(data);
            }
        });
    }
}
