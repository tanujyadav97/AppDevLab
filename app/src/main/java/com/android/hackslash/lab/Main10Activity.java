package com.android.hackslash.lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class Main10Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = null;

        if (id == R.id.lab1) {
            intent = new Intent(this, MainActivity.class);
        } else if (id == R.id.lab2) {
            intent = new Intent(this, Main2Activity.class);
        } else if (id == R.id.lab3) {
            intent = new Intent(this, Main3Activity.class);
        } else if (id == R.id.lab4) {
            intent = new Intent(this, Main4Activity.class);
        } else if (id == R.id.lab5) {
            intent = new Intent(this, Main5Activity.class);
        } else if (id == R.id.lab6) {
            intent = new Intent(this, Main6Activity.class);
        } else if (id == R.id.lab7) {
            intent = new Intent(this, Main7Activity.class);
        } else if (id == R.id.lab8) {
            intent = new Intent(this, Main8Activity.class);
        } else if (id == R.id.lab9) {
            intent = new Intent(this, Main9Activity.class);
        } else if (id == R.id.lab11) {
            intent = new Intent(this, Main11Activity.class);
        }

        startActivity(intent);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
