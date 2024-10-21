package com.example.myapplication.models.RtoModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TagRtoInfo {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rtoList")
    @Expose
    private List<Rto> rtoList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rto> getRtoList() {
        return rtoList;
    }

    public void setRtoList(List<Rto> rtoList) {
        this.rtoList = rtoList;
    }

}