package com.example.finalprojectufs08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Dettaglio extends AppCompatActivity {

    private TextView pizzaName;
    private TextView pizzaIngredienti;
    private TextView pizzaPrezzo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettaglio);

        String name = getIntent().getStringExtra("nome");
        String ingredienti = getIntent().getStringExtra("ingredienti");
        Integer prezzo = getIntent().getIntExtra("prezzo", 0);

        pizzaName = findViewById(R.id.namePizza);
        pizzaIngredienti = findViewById(R.id.ingredientiPizza);
        pizzaPrezzo = findViewById(R.id.prezzoPizza);

        pizzaName.setText(name);
        pizzaIngredienti.setText(ingredienti);
        pizzaPrezzo.setText(prezzo.toString());
    }
}