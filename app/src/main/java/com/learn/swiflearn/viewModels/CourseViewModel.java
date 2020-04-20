package com.learn.swiflearn.viewModels;

import com.learn.swiflearn.models.CourseResModel;
import com.learn.swiflearn.network.APIClient;
import com.learn.swiflearn.network.APIInterface;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseViewModel extends ViewModel {

    private MutableLiveData<CourseResModel> courseResModelMutableLiveData;
    private final APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

    public LiveData<CourseResModel> getCourse(String Subject) {

        switch (Subject) {
            case "Maths":

                courseResModelMutableLiveData = new MutableLiveData<>();
                loadMathCourses();

                break;
            case "Science":

                courseResModelMutableLiveData = new MutableLiveData<CourseResModel>();
                loadScienceCourses();

                break;
            case "English":

                courseResModelMutableLiveData = new MutableLiveData<CourseResModel>();
                loadEnglishCourses();

                break;
        }


        return courseResModelMutableLiveData;
    }

    private void loadMathCourses() {
        Call<CourseResModel> call = apiInterface.getMathCourseList();
        call.enqueue(new Callback<CourseResModel>() {
            @Override
            public void onResponse(Call<CourseResModel> call, Response<CourseResModel> response) {

                courseResModelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CourseResModel> call, Throwable t) {

            }
        });
    }

    public void loadScienceCourses() {
        Call<CourseResModel> call = apiInterface.getScienceCourseList();
        call.enqueue(new Callback<CourseResModel>() {
            @Override
            public void onResponse(Call<CourseResModel> call, Response<CourseResModel> response) {

                courseResModelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CourseResModel> call, Throwable t) {

            }
        });
    }


    public void loadEnglishCourses() {
        Call<CourseResModel> call = apiInterface.getEnglishCourseList();
        call.enqueue(new Callback<CourseResModel>() {
            @Override
            public void onResponse(Call<CourseResModel> call, Response<CourseResModel> response) {

                courseResModelMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CourseResModel> call, Throwable t) {

            }
        });
    }
}
