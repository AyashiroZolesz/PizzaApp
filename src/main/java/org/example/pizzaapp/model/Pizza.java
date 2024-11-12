package org.example.pizzaapp.model;

import java.util.ArrayList;

public class Pizza {
    private  int size;
    private ArrayList<Topping> toppings;

    public Pizza(int size)
    {
        this.size = size;
        toppings = new ArrayList<>();
    }

    public int getSize()
    {
        return size;
    }

    public ArrayList<Topping> getToppings() {
            return toppings;
    }

    public void addTopping(Topping t)
    {
        toppings.add(t);
    }

    public void removeTopping(Topping t)
    {
        toppings.remove(t);
    }

    public int totalPrice()
    {
        int price = size*50;
        for(Topping topping : toppings)
        {
            price += topping.getPrice();
        }
        return price;
    }
}
