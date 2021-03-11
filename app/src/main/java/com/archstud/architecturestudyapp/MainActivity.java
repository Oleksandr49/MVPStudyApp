package com.archstud.architecturestudyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.archstud.architecturestudyapp.fragments.ListFragment;
import com.archstud.architecturestudyapp.fragments.ListPresenter;
import com.archstud.architecturestudyapp.fragments.ObjectCreationFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity implements ObjectCreationFragment.FragmentListener{


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
            ObjectCreationFragment fragment = new ObjectCreationFragment();
            fragment.setListener(this);
            fragmentTransaction2.add(R.id.placeholderObjectCreation, fragment);
            fragmentTransaction2.addToBackStack("ObjectCreation");
            fragmentTransaction2.commit();
        });
    }

    @Override
    public void removeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void addPositionToList(String positionName) {
        ListFragment fragment = (ListFragment)getSupportFragmentManager().findFragmentById(R.id.placeholderListFragment);
        if(fragment!=null){
            ListPresenter presenter = (ListPresenter)fragment.getPresenter();
            presenter.addPositionToList(positionName);
        }
    }
}