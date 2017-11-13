package ru.utils.ocr;


import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Field implements Parcelable {

    private String name;
    private String value;

    private Bitmap image = null;

    private boolean is_image = false;
    private boolean accepted = false;

    public Field(String name, Bitmap photo, boolean accepted) {
        this.name = name;
        this.image = photo;
        this.accepted = accepted;
        this.is_image = true;
    }

    public Field(String name, String value, boolean accepted) {
        this.name = name;
        this.value = value;
        this.accepted = accepted;
        this.is_image = false;
    }


    public Field(Parcel in) {

        String[] data = new String[2];
        in.readStringArray(data);
        this.name = data[0];
        this.value = data[1];

        boolean[] flags = new boolean[2];
        in.readBooleanArray(flags);
        this.accepted = flags[0];
        this.is_image = flags[1];

        this.image = (Bitmap)in.readParcelable(Bitmap.class.getClassLoader());
    }

    public String name() {
        return name;
    }
    public String value() {
        return value;
    }
    public Bitmap image() {
        return image;
    }
    public boolean accepted() {
        return accepted;
    }
    public boolean is_image() {
        return is_image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.name, this.value});
        dest.writeBooleanArray(new boolean[] {this.accepted, this.is_image});
        dest.writeParcelable(image, flags);
    }

    public static final Creator<Field> CREATOR = new Creator<Field>() {

        @Override
        public Field createFromParcel(Parcel source) {
            return new Field(source);
        }

        @Override
        public Field[] newArray(int size) {
            return new Field[size];
        }
    };
}