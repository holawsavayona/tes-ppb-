package com.projects.kasirku.adapters;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.projects.kasirku.helpers.UIHelper;
import com.projects.kasirku.utils.GridSpacingItemDecorationUtil;

public class BindingAdapters {

    @BindingAdapter({"srcCompat"})
    public static void setImageSrcCompat(ImageView imageView, int drawable){
        imageView.setImageResource(drawable);
    }

    @BindingAdapter("setupGridRecyclerView")
    public static void setupGridRecyclerView(RecyclerView recyclerView, float margin){
        recyclerView.setLayoutManager(
                new GridLayoutManager(recyclerView.getContext(), UIHelper.newInstance(recyclerView.getContext()).calculateColumnNumber())
        );
        recyclerView.addItemDecoration(
                new GridSpacingItemDecorationUtil(margin, "grid")
        );
    }

    @BindingAdapter("setupVerticalRecyclerView")
    public static void setupVerticalRecyclerView(RecyclerView recyclerView, float margin){
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.VERTICAL, false));
        recyclerView.addItemDecoration(
                new GridSpacingItemDecorationUtil(margin, "vertical")
        );
    }

    @BindingAdapter("setupHorizontalRecyclerView")
    public static void setupHorizontalRecyclerView(RecyclerView recyclerView, float margin){
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView.addItemDecoration(
                new GridSpacingItemDecorationUtil(margin, "horizontal")
        );
    }
}
