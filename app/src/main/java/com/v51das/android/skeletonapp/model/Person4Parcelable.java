package com.v51das.android.skeletonapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Person4Parcelable implements Parcelable {

    private String name;
    private int age;

    public Person4Parcelable() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person4Parcelable(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<Person4Parcelable> CREATOR = new Creator<Person4Parcelable>() {
        @Override
        public Person4Parcelable createFromParcel(Parcel in) {
            return new Person4Parcelable(in);
        }

        @Override
        public Person4Parcelable[] newArray(int size) {
            return new Person4Parcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }
}
