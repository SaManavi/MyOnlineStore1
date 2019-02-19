package com.example.myonlinestore1.Activity;

import android.os.Bundle;

import com.example.myonlinestore1.Fragment.AllCategoriesFragment;
import com.example.myonlinestore1.Fragment.AllProductsFragment;
import com.example.myonlinestore1.Network.API;
import com.example.myonlinestore1.Network.RetrofitClientInstance;
import com.example.myonlinestore1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

//    private RecyclerView mRecyclerView;
//    private CategoriesAdapter mAdapter;
    private TextView mtest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtest=findViewById(R.id.test);


        FragmentManager fm=getSupportFragmentManager();
        if(fm.findFragmentById(R.id.fragment_container)==null) {
            fm.beginTransaction()
                    .add(R.id.fragment_container, new AllProductsFragment())
                    .commit();
        }


//        RetrofitClientInstance.getRetrofitInstance().create(API.class)
            FragmentManager fm2=getSupportFragmentManager();
            if(fm2.findFragmentById(R.id.fragment_container)==null) {
                fm2.beginTransaction()
                        .add(R.id.fragment_container2, new AllCategoriesFragment())
                        .commit();
        }

        findComponenets();

    }

    private void findComponenets() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        mRecyclerView= findViewById(R.id.newest_recycler);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        updateUI();


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
//
//    private class CategoriesViewHolder extends RecyclerView.ViewHolder{
//        private ImageView mProductImageView;
//        private TextView mProductNameTextView;
//        private TextView mProductPriceTextView;
//        private Products mProducts;
//
//
//
//        public CategoriesViewHolder(@NonNull View itemView) {
//            super(itemView);
//            mProductImageView = itemView.findViewById(R.id.product_image_view);
//            mProductNameTextView = itemView.findViewById(R.id.product_name_text_view);
//            mProductPriceTextView = itemView.findViewById(R.id.product_price_text_view);
//
//        }
//        public void bind(Products products){
//            mProducts = products;
//            mProductNameTextView.setText(products.getName());
//            mProductPriceTextView.setText(products.getPrice());
//            if(mProducts.getImages()!=null&&mProducts.getImages().size()>0){
//                Picasso.get().load(mProducts.getImages().get(0).getPath()).into(mProductImageView);
//
//            }
//
//        }
//    }
//    private class CategoriesAdapter extends RecyclerView.Adapter<CategoriesViewHolder>{
//        private List<Products> mNewestProductsList;
//
//        public CategoriesAdapter(List<Products> productsList) {
//            mNewestProductsList = productsList;
//        }
//
//        public void setAllCategoriesList(List<Products> newestProductsList) {
//            mNewestProductsList = newestProductsList;
//        }
//
//        @NonNull
//        @Override
//        public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view = LayoutInflater.from(MainActivity.this).
//                    inflate(R.layout.product_item_list,parent,false);
//            return new CategoriesViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
//            Products products = mNewestProductsList.get(position);
//            holder.bind(products);
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return mNewestProductsList.size();
//        }
//    }
//
//    private void updateUI() {
//        RetrofitClientInstance.getRetrofitInstance().create(API.class)
//                .getRoot().enqueue(new Callback<List<Products>>() {
//            @Override
//            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
//                Toast.makeText(MainActivity.this, "on responce ok..", Toast.LENGTH_SHORT).show();
//                if(response.isSuccessful()){
//                    List<Products> productsList = response.body();
//
//                    if(mAdapter==null) {
//                        mAdapter = new CategoriesAdapter(productsList);
//                        mRecyclerView.setAdapter(mAdapter);
////                    mProgressDialog.cancel();
//                    }else {
//                        mAdapter.setAllCategoriesList(productsList);
//                        mAdapter.notifyDataSetChanged();
//
//                        }
//                    }
//                    }
//
//            @Override
//            public void onFailure(Call<List<Products>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "problem with your request", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
