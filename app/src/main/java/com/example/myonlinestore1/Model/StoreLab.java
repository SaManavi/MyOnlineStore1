package com.example.myonlinestore1.Model;

import android.widget.Toast;

import com.example.myonlinestore1.Activity.MainActivity;
import com.example.myonlinestore1.Network.API;
import com.example.myonlinestore1.Network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreLab {


    public void test(){

        API api = RetrofitClientInstance.getRetrofitInstance().create(API.class);
        api.getProduct().enqueue(new Callback<List<Products>>() {

            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {

                if (response.isSuccessful()) {
                    List<Products> productsList = response.body();

                }
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
              //  Toast.makeText(MainActivity.this, "problem with your request", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
