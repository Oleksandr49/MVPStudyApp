package com.archstud.architecturestudyapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;

import com.archstud.architecturestudyapp.R;
import com.archstud.architecturestudyapp.views.fragments.ObjectListFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction listFragmentInit = getSupportFragmentManager().beginTransaction();
        listFragmentInit.replace(R.id.fragmentPlaceHolder, new ObjectListFragment());
        listFragmentInit.commit();
    }
}