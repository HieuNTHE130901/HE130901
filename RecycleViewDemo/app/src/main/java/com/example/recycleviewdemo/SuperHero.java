package com.example.recycleviewdemo;

import android.os.Parcel;
import android.os.Parcelable;

public class SuperHero implements Parcelable {
    private String name;
    private int img_id;
    private String description;

    protected SuperHero(Parcel in) {
        name = in.readString();
        img_id = in.readInt();
        description = in.readString();
    }

    public static final Creator<SuperHero> CREATOR = new Creator<SuperHero>() {
        @Override
        public SuperHero createFromParcel(Parcel in) {
            return new SuperHero(in);
        }

        @Override
        public SuperHero[] newArray(int size) {
            return new SuperHero[size];
        }
    };

    public SuperHero() {
    }

    public SuperHero(String name, int img_id, String description) {
        this.name = name;
        this.img_id = img_id;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(img_id);
        dest.writeString(description);
    }
}
