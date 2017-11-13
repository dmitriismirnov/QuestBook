package ru.utils.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class ParcelableObject
        implements Parcelable
{
// -- functions

    @SuppressWarnings("UnusedParameters")
    public Parcelable readFromParcel(Parcel src, ClassLoader loader) {
        return this;
    }

    @Override
    public void writeToParcel(Parcel dst, int flags) {
        // do nothing ...
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
