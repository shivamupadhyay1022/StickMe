package com.maasova.stickme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.maasova.stickme.Adapters.FragmentsAdapter;
import com.maasova.stickme.Fragments.MemesFragment;
import com.maasova.stickme.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tablayout.setupWithViewPager(binding.viewPager);
        setSupportActionBar(binding.toolbar);
        binding.navSide.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar,
                R.string.OpenDrawer, R.string.CloseDrawer);

        binding.drawerLayout.addDrawerListener(toggle);
        binding.navSide.setCheckedItem(R.id.nav_memes);
        binding.navSide.setNavigationItemSelectedListener(this);

        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.nav_memes){
            Toast.makeText(MainActivity.this, "Memes", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.nav_stickers){
            Toast.makeText(MainActivity.this, "Stickers", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.nav_templates) {
            Toast.makeText(MainActivity.this, "Templates", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.nav_memes) {
            Toast.makeText(MainActivity.this, "My Favourites", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.nav_follow) {
            Toast.makeText(MainActivity.this, "Follow US", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.nav_share) {
            Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.nav_send) {
            Toast.makeText(MainActivity.this, "Send Memes", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.nav_message) {
            Toast.makeText(MainActivity.this, "Message", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.nav_about) {
            Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(MainActivity.this, "Rate This app", Toast.LENGTH_SHORT).show();
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}