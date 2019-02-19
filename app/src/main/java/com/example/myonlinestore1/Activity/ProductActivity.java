package com.example.myonlinestore1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.myonlinestore1.Fragment.ProductFragment;
import com.example.myonlinestore1.R;

public class ProductActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new ProductFragment();
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_single_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
