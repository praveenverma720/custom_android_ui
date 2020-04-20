package com.learn.swiflearn.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourseDataModel {

    @SerializedName("subject_title")
    @Expose
    private String subjectTitle;
    @SerializedName("lession_title")
    @Expose
    private String lessionTitle;
    @SerializedName("lession_short_desc")
    @Expose
    private String lessionShortDesc;
    @SerializedName("taken_date")
    @Expose
    private String takenDate;
    @SerializedName("taken_by")
    @Expose
    private String takenBy;

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getLessionTitle() {
        return lessionTitle;
    }

    public void setLessionTitle(String lessionTitle) {
        this.lessionTitle = lessionTitle;
    }

    public String getLessionShortDesc() {
        return lessionShortDesc;
    }

    public String getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(String takenDate) {
        this.takenDate = takenDate;
    }

    public String getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(String takenBy) {
        this.takenBy = takenBy;
    }

}