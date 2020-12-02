package com.v51das.android.skeletonapp.egcw.gson;

import com.google.gson.annotations.SerializedName;

public class Basic {
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;
    public Update update;

    private class Update {
        @SerializedName("loc")
        String updateTime;
    }
}
