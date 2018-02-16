package com.smirnov.dmitrii.questbook.ui.fragment.story.helpers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smirnov.dmitrii.questbook.R;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.Images;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryActionItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryChapterItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryImageItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryItem;
import com.smirnov.dmitrii.questbook.ui.fragment.story.helpers.items.StoryItemType;
import com.smirnov.dmitrii.questbook.ui.model.story.action.ActionModel;
import com.smirnov.dmitrii.questbook.ui.widget.StoryTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.utils.LogUtils;

/**
 * @author Дмитрий
 * @version 18.11.2017.
 */

public class StoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = StoryAdapter.class.getSimpleName();

    private TextDisplayingListener mTextDisplayListener;
    private UserInteractionListener mUserInteractionListener;
    private List<StoryItem> mItems = new ArrayList<>();
    private final LayoutInflater mInflater;

    public StoryAdapter(@NonNull Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    public void setTextDisplayFinishListener(@Nullable TextDisplayingListener listener) {
        this.mTextDisplayListener = listener;
    }

    public void setUserInteractionListener(@Nullable UserInteractionListener listener) {
        this.mUserInteractionListener = listener;
    }

    public void addItem(@NonNull StoryItem item) {
        mItems.add(item);
        notifyItemInserted(getItemCount());
    }

    public void removeItem(int index) {
        if (index < 0 || index >= getItemCount()) {
            LogUtils.d(TAG, "impossible index: " + index);
            return;
        }

        mItems.remove(index);
        notifyItemRemoved(index);
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

        ChapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(StoryItem item) {
            final StoryChapterItem chapterItem = (StoryChapterItem) item;
            if (chapterItem.isNeedDisplayAnimation()) {
                bindNew(chapterItem);
            } else {
                rebind(chapterItem);
            }

        }

        void bindNew(StoryChapterItem chapterItem) {
            mChapterView.displayTextWithAnimation(chapterItem.getChapterText());
            mChapterView.setOnClickListener(v -> {
                mChapterView.finishDisplaying();
            });
            mChapterView.setTextDisplayListener(new TextDisplayingListener() {
                @Override
                public void onTextDisplayingFinished() {
                    if (mTextDisplayListener != null) {
                        mTextDisplayListener.onTextDisplayingFinished();
                    }
                    mChapterView.setTextDisplayListener(null);
                    chapterItem.setTextAnimated();
                }

                @Override
                public void onViewSizeChanged() {
                    if (mTextDisplayListener != null) {
                        mTextDisplayListener.onViewSizeChanged();
                    }
                }
            });
        }

        void rebind(StoryChapterItem chaperItem) {
            mChapterView.removeCallbacks();
            mChapterView.setText(chaperItem.getChapterText());
        }
    }

    @Deprecated
    class ActionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.story_action_container)
        LinearLayout mActionContainer;

        ActionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(StoryItem item, int position) {
            mActionContainer.removeAllViewsInLayout();
            StoryActionItem actionItem = (StoryActionItem) item;
            List<ActionModel> actionList = actionItem.getActionList();
            for (int i = 0; i < actionList.size(); i++) {
                final int index = i;
                String s = actionList.get(i).getName();
                TextView v = (TextView) mInflater.inflate(R.layout.item_action, null);
                v.setText(s);
                v.setOnClickListener(v1 -> {
                    if (mUserInteractionListener != null) {
                        mUserInteractionListener.onChooseAction(actionItem.getActionList().get(index));
                    }
                });
                mActionContainer.addView(v);
            }
        }
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.story_image)
        ImageView mImage;

        ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(StoryItem item) {
            if (item instanceof StoryImageItem) {
                if (((StoryImageItem) item).getImage() != Images.NO_IMAGE) {
                    mImage.setImageResource(((StoryImageItem) item).getImageResourse());
                }
            }
        }
    }

}
