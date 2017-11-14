package com.smirnov.dmitrii.questbook.ui.widget.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smirnov.dmitrii.questbook.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public class NavigationToolbar extends FrameLayout {

    @BindView(R.id.toolbar_icon_back_btn)
    ImageView mBackBtn;
    @BindView(R.id.toolbar_icon_additional_btn)
    ImageView mAdditionalBtn;
    @BindView(R.id.toolbar_icon)
    ImageView mIconView;
    @BindView(R.id.toolbar_icon_second_additional_btn)
    ImageView mSecondAdditionalBtn;
    @BindView(R.id.toolbar_background)
    RelativeLayout mBackgroundView;
    @BindView(R.id.toolbar_nav_title)
    TextView mTitle;

    private OnNavigationToolbarClickListener mListener;

    public NavigationToolbar(@NonNull Context context) {
        super(context);
        initView(context, null);
    }

    public NavigationToolbar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public NavigationToolbar(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NavigationToolbar(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs);
    }

    private void initView(@NonNull Context context, @Nullable AttributeSet attrs) {
        inflate(context, R.layout.view_navigation_toolbar, this);
        ButterKnife.bind(this);
        setUpAttributes(context, attrs);
//        mTitle.setTypeface(TypefaceUtils.load(context.getAssets(), ChatMessageHelper.BOLD_FONT_PATH));
    }

    private void setUpAttributes(@NonNull Context context, @Nullable AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.NavigationToolbar,
                    0, 0);

            try {
                setUpTitle(a);
                setUpTitleColor(a);
                setUpBackButtonIcon(a);
                setUpIcon(a);
                setUpBackground(a);
            } finally {
                a.recycle();
            }
        }
    }

    private void setUpTitle(@NonNull TypedArray a) {
        if (a.hasValue(R.styleable.NavigationToolbar_nt_title)) {
            mTitle.setText(a.getString(R.styleable.NavigationToolbar_nt_title));
        } else {
            mTitle.setText(null);
        }
    }

    private void setUpBackButtonIcon(@NonNull TypedArray a) {
        if (a.hasValue(R.styleable.NavigationToolbar_nt_back_button)) {
            mBackBtn.setImageResource(a.getResourceId(R.styleable.NavigationToolbar_nt_back_button, 0));
        } else {
            mBackBtn.setImageDrawable(null);
        }
    }

    private void setUpIcon(@NonNull TypedArray a) {
        if (a.hasValue(R.styleable.NavigationToolbar_nt_icon)) {
            mIconView.setImageResource(a.getResourceId(R.styleable.NavigationToolbar_nt_icon, 0));
        } else {
            mIconView.setImageDrawable(null);
        }
    }

    private void setUpBackground(@NonNull TypedArray a) {
        if (a.hasValue(R.styleable.NavigationToolbar_nt_background)) {
            mBackgroundView.setBackgroundResource(a.getResourceId(R.styleable.NavigationToolbar_nt_background, 0));
        } else {
            mBackgroundView.setBackground(null);
        }
    }

    private void setUpTitleColor(@NonNull TypedArray a) {
        if (a.hasValue(R.styleable.NavigationToolbar_nt_title_color)) {
            setTitleColor(ContextCompat.getColor(getContext(), a.getResourceId(R.styleable.NavigationToolbar_nt_title_color, 0)));
        }
    }

    @OnClick(R.id.toolbar_icon_back_btn)
    void onBackClick() {
        if (mListener != null) {
            mListener.onNavigationToolbarClickBackButton();
        }
    }


    public void setAdditionalButtonEnabled(boolean enabled) {
        mAdditionalBtn.setVisibility(enabled ? VISIBLE : GONE);
    }

    public void setSecondAdditionalButtonEnabled(boolean enabled) {
        mSecondAdditionalBtn.setVisibility(enabled ? VISIBLE : GONE);
    }

    public void setIconVisible(boolean isVisible) {
        mIconView.setVisibility(isVisible ? VISIBLE : GONE);
    }

    public void setBackgroundColor(@ColorInt int resId) {
        mBackgroundView.setBackgroundColor(resId);
    }

    public void setMainButtonImageResource(@DrawableRes int imageId) {
        mBackBtn.setImageResource(imageId);
    }

    public void setIconImageResource(@DrawableRes int imageId) {
        mIconView.setImageResource(imageId);
    }

    public void setAdditionalButtonImageResource(@DrawableRes int imageId) {
        mAdditionalBtn.setImageResource(imageId);
    }

    public void setSecondAdditionalButtonImageResource(@DrawableRes int imageId) {
        mSecondAdditionalBtn.setImageResource(imageId);
    }

    @OnClick(R.id.toolbar_icon_additional_btn)
    public void onAdditionalClick() {
        if (mListener != null) {
            mListener.onNavigationToolbarClickAdditionalButton();
        }
    }

    public void setNavigationBackEnabled(boolean isEnabled) {
        mBackBtn.setEnabled(isEnabled);
    }

    @OnClick(R.id.toolbar_icon_second_additional_btn)
    public void onSecondAdditionalClick() {
        if (mListener != null) {
            mListener.onNavigationToolbarClickSecondAdditionalButton();
        }
    }

    public void setTitle(@NonNull String title) {
        mTitle.setText(title);
    }

    public void setTitleColor(@ColorInt int color) {
        mTitle.setTextColor(color);
    }

    public void setOnNavigationToolbarClickListener(OnNavigationToolbarClickListener listener) {
        this.mListener = listener;
    }

    public ImageView getAdditionalButton() {
        return mAdditionalBtn;
    }

    public ImageView getSecondAdditionalButton() {
        return mSecondAdditionalBtn;
    }

    public interface OnNavigationToolbarClickListener {
        void onNavigationToolbarClickBackButton();

        void onNavigationToolbarClickAdditionalButton();

        void onNavigationToolbarClickSecondAdditionalButton();
    }
}
