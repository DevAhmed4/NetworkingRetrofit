package com.example.lenovo.networking_retrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface apiPlaceHolder {

    @GET()
    Call<Student> doThis(@Url String url);

}
