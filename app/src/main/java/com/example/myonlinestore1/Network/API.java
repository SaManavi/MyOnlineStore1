package com.example.myonlinestore1.Network;

import com.example.myonlinestore1.Model.Categories;
import com.example.myonlinestore1.Model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

        @GET("products?consumer_key=ck_122cbd79f8779c74defcc28c0cc00ce8fbfcb0ba&consumer_secret=cs_3e3c6b7c240f99ecbb8cb0c26bb84e2ab7b0c5cd")
//    @GET("categories?consumer_key=ck_122cbd79f8779c74defcc28c0cc00ce8fbfcb0ba&consumer_secret=cs_3e3c6b7c240f99ecbb8cb0c26bb84e2ab7b0c5cd ")
    Call<List<Products>> getProduct();

//
//    @GET("products/?consumer_key=" +
//            "ck_00fdf4e3f65c5275d802b412db586ba2cac6835f&consumer_secret" +
//            "=cs_d2571d995db502ea4b04bfae270b92ac447eb8ba")
//    Call<List<Products>> getRoot();

//https://woocommerce.maktabsharif.ir/wp-json/wc/v3/products?consumer_key=ck_122cbd79f8779c74defcc28c0cc00ce8fbfcb0ba&consumer_secret=cs_3e3c6b7c240f99ecbb8cb0c26bb84e2ab7b0c5cd

//https://woocommerce.maktabsharif.ir/wp-json/wc/v3/products?consumer_key=ck_122cbd79f8779c74defcc28c0cc00ce8fbfcb0ba&consumer_secret=cs_3e3c6b7c240f99ecbb8cb0c26bb84e2ab7b0c5cd


    //    @GET("/wp-json/wc/v3/products/categories?consumer_key=ck_122cbd79f8779c74defcc28c0cc00ce8fbfcb0ba&consumer_secret=cs_3e3c6b7c240f99ecbb8cb0c26bb84e2ab7b0c5cd")
    @GET("categories?consumer_key=ck_122cbd79f8779c74defcc28c0cc00ce8fbfcb0ba&consumer_secret=cs_3e3c6b7c240f99ecbb8cb0c26bb84e2ab7b0c5cd ")
    Call<List<Categories>> getCategory();
//    https://woocommerce.maktabsharif.ir/wp-json/wc/v3/products/categories?consumer_key=ck_122cbd79f8779c74defcc28c0cc00ce8fbfcb0ba&consumer_secret=cs_3e3c6b7c240f99ecbb8cb0c26bb84e2ab7b0c5cd


//@GET("81/consumer_key=ck_122cbd79f8779c74defcc28c0cc00ce8fbfcb0ba&consumer_secret=cs_3e3c6b7c240f99ecbb8cb0c26bb84e2ab7b0c5cd")


}