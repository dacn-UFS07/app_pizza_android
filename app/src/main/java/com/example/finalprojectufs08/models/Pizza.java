package com.example.finalprojectufs08.models;


public class Pizza {

    String name;
    Integer prezzo;
    String ingredienti;

    public Pizza() {}

    public Pizza(String name, Integer prezzo, String ingredienti) {
        this.name = name;
        this.prezzo = prezzo;
        this.ingredienti = ingredienti;
    }

    public String getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", prezzo='" + prezzo + '\'' +
                '}';
    }
}
