package com.example.foodapp.service;

import com.example.foodapp.model.Food;
import com.example.foodapp.model.Order;
import com.example.foodapp.repository.OrderRepository;

import java.util.List;

public class OrderService {

    private final FoodService foodService;
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository,FoodService foodService){
        this.orderRepository = orderRepository;
        this.foodService = foodService;
    }

    public boolean placeOrder(int id){
        Food food = foodService.searchFoodById(id);
        if(food == null){
            return false;
        }else {
            orderRepository.addOrder(new Order(food));
            return true;
        }
    }

    public List<Order> getOrders(){
        return orderRepository.getOrders();
    }

}
