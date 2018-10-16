package com.example.ma.demomvp.screen.category.Presenter;

import com.example.ma.demomvp.data.model.CategoryImage;
import com.example.ma.demomvp.data.repository.HomeRepository;
import com.example.ma.demomvp.data.source.CallBack;

import java.util.ArrayList;

public class CategoryPreImp implements CategoryPresenter {
    private CategoryImage mCategory;
    public CategoryPreImp(CategoryImage categoryView){
        this.mCategory = categoryView;
    }
    @Override
    public void getCategoryList(HomeRepository homeRepository) {
        homeRepository.getCategory(new CallBack<ArrayList<CategoryImage>>() {
            @Override
            public void getDataSuccess(ArrayList<CategoryImage> data) {
                mCategory.showCategory(data);
            }
        });
    }
}
