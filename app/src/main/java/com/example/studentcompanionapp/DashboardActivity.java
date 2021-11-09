package com.example.studentcompanionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.net.Uri;
import android.view.MenuItem;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.studentcompanionapp.DRVinterface.LoadMore;
import com.example.studentcompanionapp.ui.about.AboutFragment;
import com.example.studentcompanionapp.ui.home.HomeFragment;
import com.example.studentcompanionapp.ui.notice.NoticeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;



    private androidx.appcompat.widget.Toolbar toolbar;




    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.slide_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    // `onPostCreate` called when activity start-up is complete after `onStart()`
    // NOTE 1: Make sure to override the method with only a single `Bundle` argument
    // Note 2: Make sure you implement the correct `onPostCreate(Bundle savedInstanceState)` method.
    // There are 2 signatures and only `onPostCreate(Bundle state)` shows the hamburger icon.
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        toggle.onConfigurationChanged(newConfig);
    }
    //We also need to change the onOptionsItemSelected() method and allow the ActionBarToggle to handle the events.

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        //navController = Navigation.findNavController(this, R.id.fragment_layout);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.slide_navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);

//        drawerLayout.addDrawerListener(toggle);
        //      toggle.syncState();

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.slide_navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);

        // Set a Toolbar to replace the ActionBar.
        //// toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // This will display an Up icon (<-), we will replace it with hamburger later
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Find our drawer view
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        setNavigationViewListener();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.fragment_layout);


        navigationView = findViewById(R.id.slide_navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.start, R.string.close);
        drawer.setDrawerListener(toggle);


        //drawerLayout.addDrawerListener(toggle);
        //toggle.syncState();


        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

//        navigationView.setNavigationItemSelectedListener(this);

        //NavigationUI.setupWithNavController(bottomNavigationView, navController);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_about:
                setContentView(R.layout.activity_main);
                Toast.makeText(this, "About Page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_my_campus:
                setContentView(R.layout.fragment_about);
                Toast.makeText(this, "My Campus", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_announcements:
                setContentView(R.layout.fragment_notice);
                Toast.makeText(this, "Announcements", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_documents:
                Toast.makeText(this, "PDFs", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_productivity:
                Toast.makeText(this, "Productivity Page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_themes:
                Toast.makeText(this, "Select Theme", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_resources:
                Toast.makeText(this, "External Resources", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigation_share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "---" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "---");
                startActivity(Intent.createChooser(intent, "Contact Us!"));
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }
}