package com.v51das.android.skeletonapp.egcw.gson;

import com.google.gson.annotations.SerializedName;

public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;


    private class More {
        @SerializedName("txt")
        public String info;
    }

}
