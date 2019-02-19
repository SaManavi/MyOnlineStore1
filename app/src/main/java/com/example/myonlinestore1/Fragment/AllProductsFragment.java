package com.example.myonlinestore1.Fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myonlinestore1.Model.Products;
import com.example.myonlinestore1.Network.API;
import com.example.myonlinestore1.Network.RetrofitClientInstance;
import com.example.myonlinestore1.R;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllProductsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ProductsAdapter mAdapter;

    public AllProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_allpro, container, false);

        mRecyclerView= v.findViewById(R.id.all_pro_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        updateUI();


        return v;
    }


    private class ProductsViewHolder extends RecyclerView.ViewHolder{
        private ImageView mProductImageView;
        private TextView mProductNameTextView;
        private TextView mProductPriceTextView;
        private Products mProducts;



        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            mProductImageView = itemView.findViewById(R.id.product_image_view);
            mProductNameTextView = itemView.findViewById(R.id.product_name_text_view);
            mProductPriceTextView = itemView.findViewById(R.id.product_price_text_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "show product", Toast.LENGTH_SHORT).show();
                }
            });

        }
        public void bind(Products products){
            mProducts = products;
            mProductNameTextView.setText(products.getName());
            mProductPriceTextView.setText(products.getPrice());
            if(mProducts.getImages()!=null&&mProducts.getImages().size()>0){
                Picasso.get().load(mProducts.getImages().get(0).getPath()).into(mProductImageView);

            }

        }
    }
    private class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder>{
        private List<Products> mAllProductsList;

        public ProductsAdapter(List<Products> productsList) {
            mAllProductsList = productsList;
        }

        public void setAllProductsList(List<Products> allProductsList) {
            mAllProductsList = allProductsList;
        }

        @NonNull
        @Override
        public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).
                    inflate(R.layout.product_item_list,parent,false);
            return new ProductsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
            Products products = mAllProductsList.get(position);
            holder.bind(products);


        }


        @Override
        public int getItemCount() {
            return mAllProductsList.size();
        }
    }

    private void updateUI() {
        Toast.makeText(getActivity(), "update UI...", Toast.LENGTH_SHORT).show();
        API api=RetrofitClientInstance.getRetrofitInstance().create(API.class);
               api.getProduct().enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                Toast.makeText(getActivity(), "on response ok..", Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()){
                    List<Products> productsList = response.body();

                    if(mAdapter==null) {
                        mAdapter = new ProductsAdapter(productsList);
                        mRecyclerView.setAdapter(mAdapter);
                    }else {
                        mAdapter.setAllProductsList(productsList);
                        mAdapter.notifyDataSetChanged();

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_SHORT).show();
                Log.i("errorRetrofit",t.toString());
            }
        });
    }
}

