package com.example.myapplication.models.RtoModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RtoData {

    @SerializedName("tag_rto_info")
    @Expose
    private List<TagRtoInfo> tagRtoInfo;

    public List<TagRtoInfo> getTagRtoInfo() {
        return tagRtoInfo;
    }

    public void setTagRtoInfo(List<TagRtoInfo> tagRtoInfo) {
        this.tagRtoInfo = tagRtoInfo;
    }

}