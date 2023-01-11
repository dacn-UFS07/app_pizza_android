package com.example.finalprojectufs08;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigationBottomMenu = findViewById(R.id.navview);

        navigationBottomMenu.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.homeIconItem:
                    configFragmentManager(ListaDataFragment.class);
                    break;

                case R.id.profileIconItem:
                    configFragmentManager(SignInFragment.class);
                    break;
            }
            return true;
        });
    }

    private void configFragmentManager(Class fragmentClass) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragmentClass, null)
                .setReorderingAllowed(true)
                .addToBackStack("name")
                .commit();
    }
}