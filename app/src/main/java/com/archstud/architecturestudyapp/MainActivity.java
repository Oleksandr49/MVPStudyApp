package com.archstud.architecturestudyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.archstud.architecturestudyapp.fragments.ListFragment;
import com.archstud.architecturestudyapp.fragments.ObjectCreationFragment;
import com.archstud.architecturestudyapp.repository.DataObject;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity implements ObjectCreationFragment.FragmentCommander {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, new ListFragment());
        fragmentTransaction.commit();

        FloatingActionButton addPosition = findViewById(R.id.fab);
        addPosition.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
            fragmentTransaction2.add(R.id.placeholder, new ObjectCreationFragment());
            fragmentTransaction2.addToBackStack("addPositionCall");
            fragmentTransaction2.commit();
        });

    }

    @Override
    public void hideFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void updateListFragment(DataObject object) {
        ListFragment listFragment = (ListFragment)getSupportFragmentManager().findFragmentById(R.id.listFragment);
        listFragment.updateList(object);
    }
}