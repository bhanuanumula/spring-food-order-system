package com.example.foodapp.repository;

import com.example.foodapp.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<Order> orders;

    public OrderRepository(){
        orders = new ArrayList<>();
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public List<Order> getOrders(){
        return orders;
    }

    public Order searchByOrderId(int orderId){
        Order u = orders.stream().filter(o-> o.getId()==orderId).findFirst().orElse(null);
        return u;
    }

}
