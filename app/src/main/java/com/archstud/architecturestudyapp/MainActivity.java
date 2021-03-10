package com.archstud.architecturestudyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.archstud.architecturestudyapp.fragments.ListFragment;
import com.archstud.architecturestudyapp.fragments.ObjectCreationFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.placeholderListFragment, new ListFragment());
        fragmentTransaction.commit();

        FloatingActionButton addPosition = findViewById(R.id.fab);
        addPosition.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction2.add(R.id.placeholderObjectCreation, new ObjectCreationFragment());
            fragmentTransaction2.addToBackStack("addPositionCall");
            fragmentTransaction2.commit();
        });

    }
}