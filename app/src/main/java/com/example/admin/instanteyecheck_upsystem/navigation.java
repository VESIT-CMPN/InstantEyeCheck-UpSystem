package com.example.admin.instanteyecheck_upsystem;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);
        MainFragment fragment = new MainFragment();
 Session session=new Session(this);
        if(!session.loggedin())

        {
        session.setLoggedIn(false);
        finish();
        startActivity(new Intent(navigation.this,login.class));
    }

        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //noinspection deprecation
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Click back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 3000);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_feedback) {
            Intent i = new Intent(navigation.this, feedback.class);
            startActivity(i);
        } else if (id == R.id.nav_about) {
            Intent i = new Intent(navigation.this, aboutus.class);
            startActivity(i);
        } else if (id == R.id.nav_diseasedetails) {
            Intent i = new Intent(navigation.this, diseasedetails.class);
            startActivity(i);

        }
        else if (id == R.id.nav_maps) {
            Intent i = new Intent(navigation.this, MapsActivity.class);
            startActivity(i);
        }
        else if (id == R.id.nav_history) {
            Intent i = new Intent(navigation.this, history.class);
            startActivity(i);
        }
        else if (id == R.id.nav_progress) {
            Intent i = new Intent(navigation.this, progress.class);
            startActivity(i);
        }
        else if (id == R.id.nav_howtouseapp) {
            Intent i = new Intent(navigation.this, howtouseapp.class);
            startActivity(i);
        }
        else if (id == R.id.logout) {
            Session session=new Session(this);
            session.setLoggedIn(false);
            finish();
            startActivity(new Intent(navigation.this, login.class));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        return true;


    }
}