package com.example.myonlinestore1.Fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myonlinestore1.Model.Categories;
import com.example.myonlinestore1.Model.Products;
import com.example.myonlinestore1.Network.API;
import com.example.myonlinestore1.Network.RetrofitClientInstance;
import com.example.myonlinestore1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllCategoriesFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private CategoriesAdapter mAdapter;

    public AllCategoriesFragment() {
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


    private class CategoriesViewHolder extends RecyclerView.ViewHolder{
        private ImageView mCategoryImageView;
        private TextView mCategoryNameTextView;
        private Categories mCategory;



        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            mCategoryImageView = itemView.findViewById(R.id.product_image_view);
            mCategoryNameTextView = itemView.findViewById(R.id.product_name_text_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "show product", Toast.LENGTH_SHORT).show();
                }
            });

        }
        public void bind(Categories categories){
            mCategory = categories;
            mCategoryNameTextView.setText(categories.getName());
            if(mCategory.getImages()!=null&& mCategory.getImages().size()>0){
                Picasso.get().load(mCategory.getImages().get(0).getPath()).into(mCategoryImageView);

            }

        }
    }
    private class CategoriesAdapter extends RecyclerView.Adapter<CategoriesViewHolder>{
        private List<Categories> mAllCategoriesList;

        public CategoriesAdapter(List<Categories> categoriesList) {
            mAllCategoriesList = categoriesList;
        }

        public void setAllCategoriesList(List<Categories> allcategorieslist) {
            mAllCategoriesList = allcategorieslist;
        }

        @NonNull
        @Override
        public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).
                    inflate(R.layout.product_item_list,parent,false);
            return new CategoriesViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
            Categories categories = mAllCategoriesList.get(position);
            holder.bind(categories);


        }


        @Override
        public int getItemCount() {
            return mAllCategoriesList.size();
        }
    }

    private void updateUI() {
        Toast.makeText(getActivity(), "update UI category...", Toast.LENGTH_SHORT).show();
        API api=RetrofitClientInstance.getRetrofitInstance().create(API.class);
               api.getCategory().enqueue(new Callback<List<Categories>>() {
            @Override
            public void onResponse(Call<List<Categories>> call, Response<List<Categories>> response) {
                Toast.makeText(getActivity(), "on response ok..", Toast.LENGTH_SHORT).show();
                if(response.isSuccessful()){
                    List<Categories> categoriesList = response.body();

                    if(mAdapter==null) {
                        mAdapter = new CategoriesAdapter(categoriesList);
                        mRecyclerView.setAdapter(mAdapter);
                    }else {
                        mAdapter.setAllCategoriesList(categoriesList);
                        mAdapter.notifyDataSetChanged();

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Categories>> call, Throwable t) {
                Toast.makeText(getActivity(), "problem with your request", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

