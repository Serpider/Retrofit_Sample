package com.serpider.github.retrofit_sample.api;

import com.serpider.github.retrofit_sample.model.PersonPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/*
Developed for users by @Serpider
Please read the comments thoroughly before use
*/

public interface Api {
    /* Sending a request to a code file written in PHP and load to List*/
    /* Sample file in the Php Source folder with the file name get_person.php
    It is available and you can view it */
    /*Complete the RetrofitClient class before using this interface*/
    @GET("get_person.php")
    Call<List<PersonPOJO>> getPerson();

}
