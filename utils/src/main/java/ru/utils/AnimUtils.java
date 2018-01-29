package ru.utils;

import android.os.Handler;
import android.support.annotation.AnimRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * @author Dmitry Smirnov
 * @version 29.01.2018.
 */

public class AnimUtils {
    private static final String TAG = AnimUtils.class.getSimpleName();

    public static void animateView(@NonNull View view, @AnimRes int animationId) {
        Animation animation = AnimationUtils.loadAnimation(view.getContext(), animationId);
        view.post(() -> view.startAnimation(animation));
    }

    public static void animateViews(int animationId, @NonNull View... views) {
        for (View v : views) {
            animateView(v, animationId);
        }
    }

    public static void stopAnimatingView(@NonNull View view) {
        Animation animation = view.getAnimation();
        if (animation != null) {
            animation.cancel();
            animation.reset();
        }
    }

    public static void animateViewRepeatingWithoutDelay(@NonNull View view, @AnimRes int animationId) {
        final Animation animation = AnimationUtils.loadAnimation(view.getContext(), animationId);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animation.reset();
                animation.setStartOffset(0);
                animation.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.post(() -> view.startAnimation(animation));
    }

    public static void animateViewRepeatingWithDelay(@NonNull View view, @AnimRes int animationId, int delay) {
        Animation animation = AnimationUtils.loadAnimation(view.getContext(), animationId);
        animation.setStartOffset(delay);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animation.reset();
                animation.setStartOffset(0);
                animation.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        view.post(() -> view.startAnimation(animation));
    }

    public static void animateViewWithBasicCallback(@NonNull View view, @AnimRes int animationId, @Nullable Animation.AnimationListener listener) {
        Animation animation = AnimationUtils.loadAnimation(view.getContext(), animationId);
        animation.setAnimationListener(listener);
        view.post(() -> view.startAnimation(animation));
    }

    public static void animateViewWithTimeCallback(@NonNull View view, @AnimRes int animationId, int animationTimeInMillis, @NonNull AnimationTimeListener listener) {
        Animation animation = AnimationUtils.loadAnimation(view.getContext(), animationId);
        view.post(() -> view.startAnimation(animation));

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            listener.onAnimationTimeEnded();
            handler.removeCallbacksAndMessages(null);
        }, animationTimeInMillis);
    }

    public static void animateViewAppear(@NonNull View view, @AnimRes int animationId) {
        animateViewWithBasicCallback(view, animationId, new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public static void animateViewHide(@NonNull View view, @AnimRes int animationId) {
        animateViewWithBasicCallback(view, animationId, new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public interface AnimationTimeListener {
        void onAnimationTimeEnded();
    }
}
