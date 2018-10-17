package com.example.ma.demomvp.screen.categories;

import com.example.ma.demomvp.data.model.Category;
import com.example.ma.demomvp.data.repositories.CategoryRepository;
import com.example.ma.demomvp.data.source.CallBack;

import java.util.ArrayList;

public class CategoryPresenter implements CategoryContract.Presenter {
    private CategoryContract.View mView;

    public CategoryPresenter(CategoryContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getCategoryList(CategoryRepository categoryRepository) {
        categoryRepository.getCategoryData(new CallBack<ArrayList<Category>>() {
            @Override
            public void getDataSuccess(ArrayList<Category> data) {
                mView.showCategory(data);
            }

            @Override
            public void getDataError(Exception e) {
                mView.showError(e);
            }
        });
    }
}
