package com.learn.swiflearn.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CourseResModel {

    @SerializedName("data")
    @Expose
    private List<CourseDataModel> data = null;

    public List<CourseDataModel> getData() {
        return data;
    }

}
