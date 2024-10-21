package com.example.myapplication.models;

import android.media.Rating;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nil {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("price")
    @Expose
    public Integer price;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("category")
    @Expose
    public String category;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("rating")
    @Expose
    public Rating rating;

}