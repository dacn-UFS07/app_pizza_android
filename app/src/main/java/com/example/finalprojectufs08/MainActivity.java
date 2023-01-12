package com.example.finalprojectufs08;

/**
 * TODO
 * - visualizzare dati utente in pagina profilo
 */

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        BottomNavigationView navigationBottomMenu = findViewById(R.id.navview);

        navigationBottomMenu.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.homeIconItem:
                    configFragmentManager(ListaDataFragment.class);
                    break;

                case R.id.profileIconItem:
                    if(auth.getCurrentUser() != null){
                        configFragmentManager(ProfileFragment.class);

                    } else {
                        configFragmentManager(SignUpFragment.class);
                    }
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