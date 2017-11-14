package com.smirnov.dmitrii.questbook.app;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.SslErrorHandler;

import com.smirnov.dmitrii.questbook.R;

import java.lang.ref.WeakReference;

import ru.utils.ThreadUtils;
import ru.utils.data.ParcelUtils;

/**
 * @author Dmitry Smirnov
 * @version 14.11.2017.
 */

public class DialogFragmentManager {
    private WeakReference<FragmentActivity> reference;
    private Dialog mActiveDialog;
    private DialogParams currentDialogParams;

    protected DialogFragmentManager(FragmentActivity activity) {
        reference = new WeakReference<>(activity);
    }

    public static DialogFragmentManager build(FragmentActivity activity) {
        return activity == null ? null : new DialogFragmentManager(activity);
    }

    public void onSaveInstanceState(Bundle outState) {
        if (currentDialogParams != null) {
            outState.putParcelable("DialogFragmentManager_currentDialogParams", currentDialogParams);
        }
    }

    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            currentDialogParams = savedInstanceState.getParcelable("DialogFragmentManager_currentDialogParams");

            if (currentDialogParams != null) {
                if (!currentDialogParams.isHasListener()) {
                    switch (currentDialogParams.getType()) {
                        case ALERT:
                            showAlertDialog(currentDialogParams.getTitle(), currentDialogParams.getMessage(), currentDialogParams.isCancelable(), null);
                            break;
                        case YES_NO:
                            //nothing
                            break;
                        case PROGRESS:
                            //nothing
                            break;
                    }
                }
            }
        }
    }

    @Nullable
    protected FragmentActivity getActivity() {
        return reference.get();
    }

    public void showAlertDialog(int titleId, int messageId) {
        this.showAlertDialog(titleId, messageId, null);
    }

    public void showAlertDialog(CharSequence title, CharSequence message) {
        this.showAlertDialog(title, message, null);
    }

    public void showAlertDialog(int titleId, int messageId, AlertDialogListener listener) {
        this.showAlertDialog(titleId, messageId, true, listener);
    }

    public void showAlertDialog(int titleId, int messageId, boolean cancelable, AlertDialogListener listener) {
        FragmentActivity activity = this.getActivity();
        if (activity != null) {
            this.showAlertDialog(activity.getString(titleId), activity.getString(messageId), cancelable, listener);
        }

    }

    public void showAlertDialog(CharSequence title, CharSequence message, AlertDialogListener listener) {
        this.showAlertDialog(title, message, true, listener);
    }

    public void showAlertDialog(CharSequence title, CharSequence message, boolean cancelable, final AlertDialogListener listener) {
        FragmentActivity activity = this.getActivity();
        if (activity != null) {
            this.showAlertDialog(title, message, activity.getString(R.string.btn_close), cancelable, listener);
        }
    }

    public void showAlertDialog(CharSequence title, CharSequence message, CharSequence posButtonText, boolean cancelable, final AlertDialogListener listener) {
        FragmentActivity activity = this.getActivity();
        if (activity != null) {
            AlertDialog dialog = new AlertDialog.Builder(activity)
                    .setCancelable(cancelable)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton(posButtonText, (dialog1, which) -> {
                        dismissActiveDialog();
//                            dialog.goBack();
                    })
                    .setOnDismissListener(listener)
                    .create();

            currentDialogParams = new DialogParamsBuilder(DialogType.ALERT)
                    .setTitle(title)
                    .setMessage(message)
                    .setCancelable(cancelable)
                    .setHasListener(listener != null)
                    .build();

            showDialogOnUiThreadBlocking(dialog);
        }

    }

    public void showErrorAlertDialog(int messageId) {
        this.showErrorAlertDialog(messageId, true);
    }

    public void showErrorAlertDialog(int messageId, boolean cancelable) {
        this.showAlertDialog(R.string.lbl_attention, messageId, cancelable, null);
    }

    public void showErrorAlertDialog(CharSequence message) {
        this.showErrorAlertDialog(message, true);
    }

    public void showErrorAlertDialogOK(CharSequence message) {
        this.showErrorAlertDialogOK(message, true);
    }

    public void showErrorAlertDialog(CharSequence message, boolean cancelable) {
        this.showErrorAlertDialog(message, cancelable, null);
    }

    public void showErrorAlertDialog(CharSequence message, boolean cancelable, final AlertDialogListener listener) {
        FragmentActivity activity = this.getActivity();
        if (activity != null) {
            this.showAlertDialog(activity.getString(R.string.lbl_attention), message, cancelable, listener);
        }

    }

    public void showErrorAlertDialogOK(CharSequence message, boolean cancelable) {
        FragmentActivity activity = this.getActivity();
        if (activity != null) {
            this.showAlertDialog(activity.getString(R.string.lbl_attention), message, activity.getString(R.string.btn_ok), cancelable, null);
        }

    }

    public void showYesNoDialog(int titleId, int messageId, YesNoDialogListener listener) {
        this.showYesNoDialog(titleId, messageId, true, listener);
    }

    public void showYesNoDialog(int titleId, int messageId, boolean cancelable, YesNoDialogListener listener) {
        FragmentActivity activity = this.getActivity();
        if (activity != null) {
            this.showYesNoDialog(activity.getString(titleId), activity.getString(messageId), cancelable, listener);
        }

    }

    public void showYesNoDialog(CharSequence title, CharSequence message, YesNoDialogListener listener) {
        this.showYesNoDialog(title, message, true, listener);
    }

    public void showYesNoDialog(CharSequence title, CharSequence message, boolean cancelable, final YesNoDialogListener listener) {
        FragmentActivity activity = this.getActivity();
        if (activity != null) {
            AlertDialog dialog = new AlertDialog.Builder(activity)
                    .setCancelable(cancelable)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton(R.string.btn_yes, (dialog1, which) -> {
                        if (listener != null) {
                            listener.onYes(dialog1);
                        }
                        dialog1.dismiss();
                    })
                    .setNegativeButton(R.string.btn_no, (dialog12, which) -> {
                        if (listener != null) {
                            listener.onNo(dialog12);
                        }
                        dialog12.dismiss();
                    })
                    .setOnCancelListener(listener)
                    .setOnDismissListener(listener)
                    .create();

            currentDialogParams = new DialogParamsBuilder(DialogType.YES_NO)
                    .setTitle(title)
                    .setMessage(message)
                    .setCancelable(cancelable)
                    .setHasListener(listener != null)
                    .build();

            showDialogOnUiThreadBlocking(dialog);
        }

    }

    public void showProgressDialog(int textId) {
        this.showProgressDialog(textId, true);
    }

    public void showProgressDialog(int textId, boolean cancelable) {
        FragmentActivity activity = this.getActivity();
        if (activity != null) {
            this.showProgressDialog(activity.getString(textId), cancelable, null);
        }

    }

    public void showProgressDialog(CharSequence message) {
        this.showProgressDialog(message, true);
    }

    public void showProgressDialog(CharSequence message, boolean cancelable) {
        this.showProgressDialog(message, cancelable, null);
    }

    public void showProgressDialog(int textId, boolean cancelable, ProgressDialogListener listener) {
        FragmentActivity activity = this.getActivity();
        if (activity != null) {
            this.showProgressDialog(activity.getString(textId), cancelable, listener);
        }

    }

    public void showProgressDialog(CharSequence message, boolean cancelable, final ProgressDialogListener listener) {
        final FragmentActivity activity = this.getActivity();
        if (activity != null) {
            ProgressDialog dialog = new ProgressDialog(activity);
            dialog.setMessage(message);
            dialog.setCancelable(cancelable);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setOnCancelListener(new ProgressDialogListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {
                    if (listener != null) {
                        listener.onCancel(dialogInterface);
                    }
                    dismissActiveDialog();
                }

                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    dismissActiveDialog();
                }
            });
            if (cancelable) {
                dialog.setOnDismissListener(listener);
            }

            currentDialogParams = new DialogParamsBuilder(DialogType.PROGRESS)
                    .setMessage(message)
                    .setCancelable(cancelable)
                    .setHasListener(listener != null)
                    .build();

            showDialogOnUiThreadBlocking(dialog);
        }

    }

    public void showCustomDialog(Dialog fragment) {
        this.showDialogOnUiThreadBlocking(fragment);
    }

    public void dismissActiveDialog() {
        currentDialogParams = null;
        this.showDialogOnUiThreadBlocking(null);
    }

    private void showDialogOnUiThreadBlocking(final Dialog dialog) {
        ThreadUtils.runOnUiThreadBlocking(() -> DialogFragmentManager.this.replaceActiveDialog(dialog));
    }

    private void replaceActiveDialog(Dialog dialog) {
        FragmentActivity activity = this.getActivity();
        synchronized (this) {

            if (activity == null) return;

            if (this.mActiveDialog != null) {

                if (mActiveDialog instanceof ProgressDialog && dialog instanceof ProgressDialog) {
                    return;
                }

                this.mActiveDialog.dismiss();
            }

            this.mActiveDialog = dialog;
            if (dialog != null) {
                Window window = dialog.getWindow();
                if (window != null) {
                    if (activity.getResources().getBoolean(R.bool.dialog_need_change_windows_size)) {
                        if (dialog instanceof ProgressDialog) {
                            window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        } else {
                            window.setLayout(activity.getResources().getDimensionPixelSize(R.dimen.dialog_width), ViewGroup.LayoutParams.WRAP_CONTENT);
                        }
                    }
                    dialog.show();
                }
            }
        }
    }

    private enum DialogType {
        ALERT, YES_NO, PROGRESS
    }

    public interface ProgressDialogListener extends DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    }

    public interface AlertDialogListener extends DialogInterface.OnDismissListener {

    }

    public interface YesNoDialogListener extends DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
        void onYes(DialogInterface dialog);

        void onNo(DialogInterface dialog);
    }

    public static abstract class SimpleDialogListener implements ProgressDialogListener, AlertDialogListener, YesNoDialogListener {

        @Override
        public void onYes(DialogInterface dialog) {

        }

        @Override
        public void onNo(DialogInterface dialog) {

        }

        @Override
        public void onCancel(DialogInterface dialog) {

        }

        @Override
        public void onDismiss(DialogInterface dialog) {

        }
    }

    private static class DialogParamsBuilder {

        private DialogType type;
        private boolean cancelable;
        private boolean hasListener;
        private CharSequence title;
        private CharSequence message;

        public DialogParamsBuilder(DialogType type) {
            this.type = type;
        }

        public DialogParamsBuilder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public DialogParamsBuilder setHasListener(boolean hasListener) {
            this.hasListener = hasListener;
            return this;
        }

        public DialogParamsBuilder setTitle(CharSequence title) {
            this.title = title;
            return this;
        }

        public DialogParamsBuilder setMessage(CharSequence message) {
            this.message = message;
            return this;
        }

        public DialogParams build() {
            return new DialogParams(type, cancelable, hasListener, title, message);
        }
    }

    private static class DialogParams implements Parcelable {

        public static final Creator<DialogParams> CREATOR = new Creator<DialogParams>() {
            public DialogParams createFromParcel(Parcel source) {
                return new DialogParams(source);
            }

            public DialogParams[] newArray(int size) {
                return new DialogParams[size];
            }
        };
        private DialogType type;
        private boolean cancelable;
        private boolean hasListener;
        private CharSequence title;
        private CharSequence message;

        public DialogParams(DialogType type, boolean cancelable, boolean hasListener, CharSequence title, CharSequence message) {
            this.type = type;
            this.cancelable = cancelable;
            this.hasListener = hasListener;
            this.title = title;
            this.message = message;
        }

        protected DialogParams(Parcel in) {
            int tmpType = in.readInt();
            this.type = tmpType == -1 ? null : DialogType.values()[tmpType];
            this.cancelable = in.readByte() != 0;
            this.hasListener = in.readByte() != 0;
            if (ParcelUtils.readBooleanFromParcel(in))
                this.title = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
            if (ParcelUtils.readBooleanFromParcel(in))
                this.message = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        }

        public DialogType getType() {
            return type;
        }

        public boolean isCancelable() {
            return cancelable;
        }

        public boolean isHasListener() {
            return hasListener;
        }

        public CharSequence getTitle() {
            return title;
        }

        public CharSequence getMessage() {
            return message;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.type == null ? -1 : this.type.ordinal());
            dest.writeByte(cancelable ? (byte) 1 : (byte) 0);
            dest.writeByte(hasListener ? (byte) 1 : (byte) 0);
            if (ParcelUtils.writeBooleanToParcel(dest, title != null))
                TextUtils.writeToParcel(title, dest, flags);
            if (ParcelUtils.writeBooleanToParcel(dest, message != null))
                TextUtils.writeToParcel(message, dest, flags);
        }
    }
}
