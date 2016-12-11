package com.runexa.hci_uas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, HomeFragment.OnHomeButtonSelected {

    FragmentManager fm = getSupportFragmentManager();
    int frame = R.id.frame_main;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.getMenu().getItem(0).setChecked(true);

        fm.beginTransaction().replace(frame,new HomeFragment()).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(fm.getBackStackEntryCount() == 0){
                finish();
                //super.onBackPressed();
            } else {

                fm.popBackStack();
            }
        }
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    } */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            fm.beginTransaction().replace(frame,new HomeFragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_applied) {
            Bundle bundl = new Bundle();
            bundl.putBoolean("AppliedOnly",true);
            Fragment f = new JobListFragment();
            f.setArguments(bundl);
            fm.beginTransaction().replace(frame,f).addToBackStack(null).commit();
        } else if (id == R.id.nav_category) {
            fm.beginTransaction().replace(frame,new JobCategoryFragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_cv) {
            fm.beginTransaction().replace(frame,new CVFragment()).addToBackStack(null).commit();
        } else if (id == R.id.nav_help) {
            Toast.makeText(this,"Not Implemented",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_logout) {
            Intent intent = new Intent(this, StartActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void OnButtonSelected(int i) {
        switch(i){
            case 1 :
                navigationView.getMenu().getItem(1).setChecked(true);
                break;
            case 2 :
                navigationView.getMenu().getItem(2).setChecked(true);
                break;
            case 3 :
                navigationView.getMenu().getItem(3).setChecked(true);
                break;
            default:
                navigationView.getMenu().getItem(0).setChecked(true);
                break;
        }
    }
}
