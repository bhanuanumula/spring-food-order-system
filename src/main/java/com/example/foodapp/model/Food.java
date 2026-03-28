package com.example.foodapp.model;

public class Food {

    private int id;

    private static int genId = 1;

    private String name;

    private double price;

    public Food(String name,double price){
        this.name = name;
        this.price = price;
        this.id = genId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
