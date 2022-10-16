package com.serpider.github.retrofit_sample.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
Developed for users by @Serpider
Please read the comments thoroughly before use
*/

public class RetrofitClient {

    /*In this section, you must enter your domain and save your files and give a link like the example*/
    private static String BASE_URL = "http://192.168.249.75/RetofitDb/";

    private static RetrofitClient myClient;

    private Retrofit retrofit;
    /*Basic use of the retrofit library*/
    private RetrofitClient(){

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();

    }
    public static synchronized RetrofitClient getInstance(){
        if(myClient == null){
            myClient = new RetrofitClient();
        }
        return myClient;
    }

    /*Constractor Api*/
    public Api getApi(){

        return retrofit.create(Api.class);
    }

}
