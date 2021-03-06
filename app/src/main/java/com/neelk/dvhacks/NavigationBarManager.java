package com.neelk.dvhacks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class NavigationBarManager extends AppCompatActivity {

    private android.support.v4.app.Fragment fragment;
    private BottomNavigationView mBottomNavigationView;
    private FragmentTransaction toHomeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar_manager);

        toHomeFragment = getSupportFragmentManager().beginTransaction();
        toHomeFragment.replace(R.id.constraint_layout, Home.newInstance());
        toHomeFragment.addToBackStack(null);
        toHomeFragment.commit();

        mBottomNavigationView = findViewById(R.id.navigation);


        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });


    }

    public void selectFragment(MenuItem item) {
        fragment = null;
        FragmentTransaction ft;
        Intent intent;
        switch (item.getItemId()) {

            case R.id.menu_home:
                fragment = Home.newInstance();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.constraint_layout, fragment, "Home");
                ft.addToBackStack(null);
                ft.commit();
                break;


            case R.id.menu_camera:
                fragment = Fragment2.newInstance(this);
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.constraint_layout, fragment, "Camera");
                ft.addToBackStack(null);
                ft.commit();
                break;


            case R.id.menu_map:
                fragment = MapFragment.newInstance();
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.constraint_layout, fragment, "Map");
                ft.addToBackStack(null);
                ft.commit();
                break;

        }
    }


}
