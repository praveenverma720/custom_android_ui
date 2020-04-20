package com.learn.swiflearn.network;


import com.learn.swiflearn.models.CourseResModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {


/*********************************************  NEW APIs  ************************************************/

// Get Maths Course
    @GET("maths")
    Call<CourseResModel> getMathCourseList();

    // Get Maths Course
    @GET("science")
    Call<CourseResModel> getScienceCourseList();

    // Get Maths Course
    @GET("english")
    Call<CourseResModel> getEnglishCourseList();

}