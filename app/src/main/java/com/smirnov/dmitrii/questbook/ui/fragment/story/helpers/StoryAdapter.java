package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.smirnov.dmitrii.questbook.R;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryActionItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryChaperItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryImageItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryItemType;
import com.smirnov.dmitrii.questbook.ui.widget.StoryTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    public StoryItem getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == StoryItemType.CHAPTER) {
            View v = mInflater.inflate(R.layout.item_story_chapter, parent, false);
            return new ChapterViewHolder(v);
        } else if (viewType == StoryItemType.ACTION) {
            View v = mInflater.inflate(R.layout.item_story_action, parent, false);
            return new ActionViewHolder(v);
        } else /*if (viewType == StoryItemType.IMAGE)*/ {
            View v = mInflater.inflate(R.layout.item_story_image, parent, false);
            return new ImageViewHolder(v);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ChapterViewHolder) {
            ((ChapterViewHolder) holder).bind(getItem(position));
        } else if (holder instanceof ActionViewHolder) {
            ((ActionViewHolder) holder).bind(getItem(position), position);
        } else if (holder instanceof ImageViewHolder) {
            ((ImageViewHolder) holder).bind(getItem(position));
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ChapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.story_text)
        StoryTextView mChapterView;

        public ChapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(StoryItem item) {
            StoryChaperItem chaperItem = (StoryChaperItem) item;
            mChapterView.displayTextWithAnimation(chaperItem.getChapterText());
        }
    }

    class ActionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.story_action_container)
        LinearLayout mActionContainer;

        public ActionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(StoryItem item, int position) {
            StoryActionItem actionItem = (StoryActionItem) item;
        }
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.story_image)
        ImageView mImage;

        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(StoryItem item) {
            if (item instanceof StoryImageItem) {
                mImage.setImageResource(((StoryImageItem) item).getImageResourse());
            }
        }
    }

}
