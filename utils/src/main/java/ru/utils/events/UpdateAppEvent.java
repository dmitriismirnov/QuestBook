package ru.utils.events;

public class UpdateAppEvent {
// -- construction

    public UpdateAppEvent(String url, String message, boolean isMandatory) {
        mMessage = message;
        mUrl = url;
        mIsMandatory = isMandatory;
    }

// -- functions

    public boolean isMandatory() {
        return mIsMandatory;
    }

    public String getMessage() {
        return mMessage;
    }

    public String getUrl() {
        return mUrl;
    }

// -- variables

    private final String mMessage;
    private final String mUrl;
    private final boolean mIsMandatory;
}
