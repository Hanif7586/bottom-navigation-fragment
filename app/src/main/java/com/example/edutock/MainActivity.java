package com.example.edutock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment1, fragment2, fragment3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Initialize fragments
        fragment1 = new HomeFragment(); // Replace with your Fragment instances
        fragment2 = new MoreFragment();
        fragment3 = new MoreFragment();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Set listener for item click events
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                // Check which item was clicked
                if (id == R.id.Home) {
                    // Load Fragment1 when the Home button is clicked
                    loadFragment(fragment1);
                    return true;
                } else if (id == R.id.Class) {
                    // Load Fragment2 when Dashboard button is clicked
                    loadFragment(fragment1);
                    return true;
                } else if (id == R.id.More) {
                    // Load Fragment3 when Notifications button is clicked
                    loadFragment(fragment3);
                    return true;
                }

                return false;
            }
        });

        // Set the default selected fragment
        loadFragment(fragment1); // Replace with your default fragment
    }

    // Function to load fragments
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.flFragment, fragment); // Replace fragmentContainer with your fragment container ID
        transaction.addToBackStack(null); // Optional: Add transaction to the back stack
        transaction.commit();
    }
}