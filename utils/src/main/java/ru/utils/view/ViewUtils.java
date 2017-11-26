package ru.utils.view;


import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import ru.utils.ThreadUtils;

public final class ViewUtils {
// -- construction

    private static AtomicBoolean blockClick = new AtomicBoolean(false);
    private static AtomicLong lastClickTime = new AtomicLong(0);
    private ViewUtils() {
        // do nothing ..
    }

    public static boolean blockClick(long delayToUnblock) {
        if (lastClickTime.get() > System.currentTimeMillis()) return true;
        lastClickTime.set(System.currentTimeMillis() + delayToUnblock);
        return false;
    }

    public static boolean blockClick() {
        return blockClick(500);
    }

    public static boolean blockClickOld() {
        if (blockClick.get()) return true;
        blockClick.set(true);

        ThreadUtils.postOnUiThreadDelayed(new Runnable() {
            @Override
            public void run() {
                blockClick.set(false);
            }
        }, 500);
        return false;
    }

// -- functions

    public static void insetViewForToolbar(View view) {
        if (view != null) {
            final TypedArray styledAttributes = view.getContext().getTheme().obtainStyledAttributes(
                    new int[]{android.R.attr.actionBarSize});
            int actionBarSize = (int) styledAttributes.getDimension(0, 0);
            styledAttributes.recycle();

            int top = view.getPaddingTop() + actionBarSize;
            int left = view.getPaddingLeft();
            int right = view.getPaddingRight();
            int bottom = view.getPaddingBottom();

            view.setPadding(left, top, right, bottom);
        }
    }

//    public static void setupViewForHideKeyboardByTouch(final Activity activity, View view, List<View> excludeViews) {
//        //Set up touch listener for non-text box views to hide keyboard.
//
//        if (excludeViews != null) {
//            for (View excludeView : excludeViews) {
//                if (excludeView == view) {
//                    return;
//                }
//            }
//        }
//        if ((view instanceof EditText)
//                || (view instanceof StyledEditText)
//                || (view instanceof SearchBarView)
//                || (view instanceof StyledShotCardInputText)
//                || (view instanceof NumericKeyboardView)
//                || (view instanceof Button)) {
//            return;
//        }
//
//
//        view.setOnTouchListener(new View.OnTouchListener() {
//            public boolean onTouch(View v, MotionEvent event) {
//                hideSoftKeyboard(activity);
//                return false;
//            }
//        });
//
//        //If a layout container, iterate over children
//        if (view instanceof ViewGroup) {
//            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
//                View innerView = ((ViewGroup) view).getChildAt(i);
//                setupViewForHideKeyboardByTouch(activity, innerView, excludeViews);
//            }
//        }
//    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            IBinder windowToken = currentFocus.getWindowToken();
            inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
            currentFocus.clearFocus();
        }
    }

    public static int getStatusBarHeight(final Context context) {
        final Resources resources = context.getResources();
        final int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
            return resources.getDimensionPixelSize(resourceId);
        else
            return (int) Math.ceil(25 * resources.getDisplayMetrics().density);
    }

    public static void setListViewHeightBasedOnChildren(ListView listview) {
        ListAdapter listAdapter = listview.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listview.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listview);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listview.getLayoutParams();
        params.height = totalHeight + (listview.getDividerHeight() * (listAdapter.getCount() - 1));
        listview.setLayoutParams(params);
        listview.requestLayout();
    }


    public static void setViewEnabled(View view, boolean enabled) {
        if (view == null)
            return;

        // How to disable/enable all children on LinearLayout in Android
        // @link http://stackoverflow.com/a/9716149

        view.setEnabled(enabled);

        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;

            for (int idx = 0; idx < group.getChildCount(); ++idx) {
                setViewEnabled(group.getChildAt(idx), enabled);
            }
        }
    }

    public static void hideKeyboard(Context c, IBinder windowToken) {
        InputMethodManager mgr = (InputMethodManager) c.getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(windowToken, 0);
    }

    public static Activity contextToActivity(Context context) {
        Activity result = null;
        if (context != null) {
            if (context instanceof Activity) {
                result = (Activity) context;
            } else {
                if (context instanceof ContextWrapper) {
                    result = contextToActivity(((ContextWrapper) context).getBaseContext());
                }
            }
        }
        return result;
    }

    public static void setMargins(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

    public static void showKeyboardDelayed(final Activity activity, long delay) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (activity != null) {
                    InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        View currentFocus = activity.getCurrentFocus();
                        if (currentFocus != null) {
                            imm.showSoftInput(currentFocus, 0);
                        } else {
                            imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
                        }
                    }
                }
            }
        }, delay);
    }

    public static void showKeyboardDelayed(final View view, long delay) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (imm != null) {
                        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
                    }
                }
            }
        }, delay);
    }

    /**
     * Merges passed input filters with existing ones for text view
     */
    public static <T extends TextView> void addFilters(T view, InputFilter... filters) {
        InputFilter[] existingFilters = view.getFilters();
        InputFilter[] resultFilters = new InputFilter[existingFilters.length + filters.length];
        System.arraycopy(existingFilters, 0, resultFilters, 0, existingFilters.length);
        System.arraycopy(filters, 0, resultFilters, existingFilters.length, filters.length);
        view.setFilters(resultFilters);
    }

    /**
     * Simulates focus forwarding to view set as next (View.FOCUS_DOWN) for source.
     *
     * @param root   host view that contains source.
     * @param source that currently has focus.
     */
    public static void requestNextFocus(View root, View source) {
        View target = root.findViewById(source.getNextFocusDownId());
        if (target != null) {
            target.requestFocus(View.FOCUS_DOWN);
        }
    }


    public static int getTextWidth(EditText view) {
        Rect bounds = new Rect();
        Paint textPaint = view.getPaint();
        textPaint.getTextBounds(view.getText().toString(), 0, view.getText().length(), bounds);
        return bounds.width();
    }

    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    public static class ViewIdHierarchy implements Parcelable {
        public static final Creator<ViewIdHierarchy> CREATOR = new Creator<ViewIdHierarchy>() {
            public ViewIdHierarchy createFromParcel(Parcel source) {
                return new ViewIdHierarchy(source);
            }

            public ViewIdHierarchy[] newArray(int size) {
                return new ViewIdHierarchy[size];
            }
        };

        private int id;
        private List<Integer> parentsIds;

        public ViewIdHierarchy(View view) {
            id = view.getId();
            parentsIds = new ArrayList<>();
            ViewParent parent = view.getParent();
            while (parent != null) {
                if (parent instanceof View) {
                    View parentView = (View) parent;
                    if (parentView.getId() != View.NO_ID) {
                        if (id == View.NO_ID) {
                            id = parentView.getId();
                        }
                        parentsIds.add(parentView.getId());
                    }
                }
                parent = parent.getParent();
            }
            Collections.reverse(parentsIds);
        }

        protected ViewIdHierarchy(Parcel in) {
            this.id = in.readInt();
            this.parentsIds = new ArrayList<>();
            in.readList(this.parentsIds, List.class.getClassLoader());
        }

        public int getId() {
            return id;
        }

        public List<Integer> getParentsIds() {
            return parentsIds;
        }

        public View findView(View view) {
            if (view == null) return null;
            List<Integer> ids = new ArrayList<>(parentsIds);
            ids.add(id);
            return findView(view, ids);
        }

        public View findView(Fragment fragment) {
            if (fragment == null) return null;
            return findView(fragment.getView());
        }

        public View findView(Activity activity) {
            if (activity == null) return null;
            List<Integer> ids = new ArrayList<>(parentsIds);
            ids.add(id);
            Integer remove = ids.remove(0);
            View viewById = activity.findViewById(remove);
            if (ids.size() > 0) {
                return findView(viewById, ids);
            }
            return viewById;
        }

        private View findView(View view, List<Integer> ids) {
            if (view == null) return null;
            if (ids.isEmpty()) return null;
            Integer remove = ids.remove(0);
            View viewById = view.findViewById(remove);
            if (ids.size() > 0) {
                return findView(viewById, ids);
            }
            return viewById;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.id);
            dest.writeList(this.parentsIds);
        }
    }
}
