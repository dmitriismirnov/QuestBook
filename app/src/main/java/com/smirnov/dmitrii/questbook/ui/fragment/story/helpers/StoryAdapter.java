package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дмитрий on 18.11.2017.
 */

public class StoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<StoryItem> mItems = new ArrayList<>();
    private final LayoutInflater mInflater;

    public StoryAdapter(@NonNull Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    public void addItem(@NonNull StoryItem item) {
        mItems.add(item);
        notifyItemInserted(getItemCount());
    }

    public void removeAllItems() {
        mItems.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
