package com.example.datting.Meet;

import androidx.recyclerview.widget.DiffUtil;

import com.example.datting.Model.Meet;

import java.util.ArrayList;

public class CardStackCallback extends DiffUtil.Callback {

    ArrayList<Meet> old, baru;
    public CardStackCallback(ArrayList<Meet> old, ArrayList<Meet> baru) {
        this.old = old;
        this.baru = baru;
    }

    @Override
    public int getOldListSize() {
        return old.size();
    }

    @Override
    public int getNewListSize() {
        return baru.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition).getImage() == baru.get(newItemPosition).getImage();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition) == baru.get(newItemPosition);
    }
}
