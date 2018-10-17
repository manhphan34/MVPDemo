package com.example.ma.demomvp.screen.categories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ma.demomvp.R;
import com.example.ma.demomvp.data.model.Category;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CatViewHolder> {
    private static final int WIDTH_IMAGE = 250,HEIGHT_IMAGE = 200;
    private Context mContext;
    private ArrayList<Category> mCategories;

    public CategoryAdapter(Context mContext, ArrayList<Category> mCategories) {
        this.mContext = mContext;
        this.mCategories = mCategories;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_item, viewGroup, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder catViewHolder, int i) {
        Category category = mCategories.get(i);
        Picasso.get().load(category.getmCatPathImage())
                .resize(WIDTH_IMAGE, HEIGHT_IMAGE)
                .into(catViewHolder.mCatImage);
        catViewHolder.mCatName.setText(category.getmCatName());
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public class CatViewHolder extends RecyclerView.ViewHolder {
        private ImageView mCatImage;
        private TextView mCatName;
        private View mView;

        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            mCatImage = mView.findViewById(R.id.image_view_category);
            mCatName = mView.findViewById(R.id.text_view_category);
        }
    }
}
