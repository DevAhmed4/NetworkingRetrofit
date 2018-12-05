package com.example.lenovo.networking_retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private apiPlaceHolder jsonPlaceHolderApi;
    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://stdattendance.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(apiPlaceHolder.class);
        createPost();
    }

    private void createPost() {

        Call<Student> call = jsonPlaceHolderApi.doThis("http://stdattendance.com/api.php?studentname=3aaaash yastaaaa&xx=-10");

        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code()+"\n");
                    textViewResult.append(call.toString());
                    return;
                }
                textViewResult.setText("Here - Code: " + response.code());
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
//        call.enqueue(new Callback<Void>() {
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if (!response.isSuccessful()) {
//                    textViewResult.setText("Code: " + response.code()+"\n");
//                    textViewResult.append(call.toString());
//                    return;
//                }
//                //textViewResult.setText("Here - Code: " + response.code());
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                textViewResult.setText(t.getMessage());
//            }
//        });
    }
}
