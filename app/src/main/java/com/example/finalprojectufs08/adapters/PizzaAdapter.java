package com.example.finalprojectufs08.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectufs08.models.Pizza;
import com.example.finalprojectufs08.R;
import com.example.finalprojectufs08.interfaces.RecyclerViewInterface;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder> {

    Context context;
    ArrayList<Pizza> pizzas;
    private final RecyclerViewInterface recyclerViewInterface;


    public PizzaAdapter(Context context, ArrayList<Pizza> pizzas, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.pizzas = pizzas;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        return new PizzaViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder holder, int position) {
        Pizza pizza = pizzas.get(position);
        holder.name.setText(pizza.getName());
        holder.ingredienti.setText(pizza.getIngredienti());
        holder.prezzo.setText(String.valueOf(pizza.getPrezzo()));
    }

    @Override
    public int getItemCount() {
        return pizzas.size();
    }

    public static class PizzaViewHolder extends RecyclerView.ViewHolder {

        TextView name, ingredienti, prezzo;

        public PizzaViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            ingredienti = itemView.findViewById(R.id.ingredienti);
            prezzo = itemView.findViewById(R.id.prezzo);

            itemView.setOnClickListener(view -> {
                if (recyclerViewInterface != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION)
                        recyclerViewInterface.onItemClick(position);
                }
            });
        }
    }
}
