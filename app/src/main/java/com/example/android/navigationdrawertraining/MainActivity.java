package com.example.android.navigationdrawertraining;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;


    android.support.v4.app.FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialise toolbar to application action bar//
        toolbar = (Toolbar) findViewById(R.id.toolbar_actionBar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;

        //Initialise drawerLayout and add listener//
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);

        //Initialise FragmentTransaction and set the first page to Policy page//
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new PolicyFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle(R.string.policy_fragment);

        //Set the Listener to NavigationView//
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(navigationViewListener);

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    public NavigationView.OnNavigationItemSelectedListener navigationViewListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {

            assert getSupportActionBar() != null;
            switch (item.getItemId()) {
                case R.id.nav_policy:
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_container, new PolicyFragment());
                    fragmentTransaction.commit();
                    getSupportActionBar().setTitle(R.string.policy_fragment);
                    item.setChecked(true);
                    drawerLayout.closeDrawers();
                    break;

                case R.id.nav_commission:
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_container, new CommisionFragment());
                    fragmentTransaction.commit();
                    getSupportActionBar().setTitle(R.string.commission_fragment);
                    item.setChecked(true);
                    drawerLayout.closeDrawers();
                    break;

                case R.id.nav_setting:
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.main_container, new SettingsFragment());
                    fragmentTransaction.commit();
                    getSupportActionBar().setTitle(R.string.settings_fragment);
                    item.setChecked(true);
                    drawerLayout.closeDrawers();
                    break;
            }
            return false;
        }
    };


}
