package com.senosy.soccer.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.senosy.soccer.R;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bttm_nav)
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpNavigation();
    }

    public void setUpNavigation(){
        bottomNavigationView =findViewById(R.id.bttm_nav);
        NavHostFragment navHostFragment =       (NavHostFragment)getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,
                navHostFragment.getNavController());
    }
}
