package com.example.routinery;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity6 extends AppCompatActivity  {
    private SearchFragment searchFragment =  new SearchFragment();
    private TextView tv ;
    private ImageView clock;

    @Override
    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        /******** bottomNav.setOnNavigationItemReselectedListener
                (new BottomNavigationView.OnNavigationItemReselectedListener() {
                    @Override
                    public void onNavigationItemReselected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.Clock:
                                Intent intent = new
                                        Intent(MainActivity6.this, dashboard.class);
                                startActivity(intent);
                                break;


                        }

                    }
                });
        *******/
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new AndroidFragment())
                .commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.Clock:
                    selectedFragment = new AndroidFragment();
                    break;
                case R.id.Tower:
                    //selectedFragment = new HomeFragment();
                    Intent intent = new
                            Intent(MainActivity6.this, Home1.class);
                    startActivity(intent);
                    break;


                case R.id.Person:
                    selectedFragment = new SearchFragment();

                 break;

            }


            getSupportFragmentManager().beginTransaction().replace(R.id.container,selectedFragment)
                    .commit();
            return true;
        }
    };



}