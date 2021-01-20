package com.example.datting.Home.Home;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class CustomItemDecorator extends RecyclerView.ItemDecoration {
    private int space;
    private int space1;

    public CustomItemDecorator(int space, int space1) {
        this.space = space;
        this.space1 = space1;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        // vị trí item = 1
        if (recyclerView.getChildLayoutPosition(view) == 1) {
            outRect.top = space1 - space;
        } else {
            outRect.top = space;
        }

    }
}
