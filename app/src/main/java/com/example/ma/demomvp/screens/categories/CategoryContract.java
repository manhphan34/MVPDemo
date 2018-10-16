package com.example.ma.demomvp.screens.categories;

import com.example.ma.demomvp.data.model.Category;
import com.example.ma.demomvp.data.repositories.CategoryRepository;

import java.util.ArrayList;

public interface CategoryContract {
    interface CategoryView{
        void showCategory(ArrayList<Category> data) ;
    }
    interface CategoryPresenter{
        void getCategoryList(CategoryRepository categoryRepository);
    }
}
