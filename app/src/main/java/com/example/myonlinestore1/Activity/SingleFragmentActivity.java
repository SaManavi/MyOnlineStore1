package com.example.myonlinestore1.Activity;

import android.os.Bundle;


import com.example.myonlinestore1.R;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * All activities that host one fragment must extend this class
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    public abstract Fragment createFragment();

    @LayoutRes
    public abstract int getLayoutResId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager.findFragmentById(R.id.fragment_list_container) == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_list_container, createFragment())
                    .commit();
        }
    }
}
