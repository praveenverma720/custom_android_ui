package com.learn.swiflearn.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {


    public static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

       OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
               .connectTimeout(120, TimeUnit.SECONDS)
               .readTimeout(120, TimeUnit.SECONDS)
               .writeTimeout(120,TimeUnit.SECONDS)
               .addInterceptor(interceptor);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vermasoft.in")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build())
                .build();

        return retrofit;
    }

}