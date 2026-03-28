package com.example.foodapp.model;

public class Order {

    private int id;

    private static int genId = 1;

    private Food food;

    private double bill;

    public Order(Food food){
        this.food = food;
        this.bill = food.getPrice();
        this.id = genId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBill(){
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", food=" + food +
                ", bill=" + bill +
                '}';
    }
}
