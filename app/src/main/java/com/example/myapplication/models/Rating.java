package com.example.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("rate")
    @Expose
    public Double rate;
    @SerializedName("count")
    @Expose
    public Integer count;

}