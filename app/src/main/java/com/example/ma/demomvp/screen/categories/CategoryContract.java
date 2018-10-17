package com.example.ma.demomvp.screen.categories;

import com.example.ma.demomvp.data.model.Category;
import com.example.ma.demomvp.data.repositories.CategoryRepository;

import java.util.ArrayList;

public interface CategoryContract {
    interface View{
        void showError(Exception e);
        void showCategory(ArrayList<Category> categories);
    }
    interface Presenter{
        void getCategoryList(CategoryRepository categoryRepository);
    }
}
