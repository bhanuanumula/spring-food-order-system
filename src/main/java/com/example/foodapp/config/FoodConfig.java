package com.example.foodapp.config;

import com.example.foodapp.service.FoodService;
import com.example.foodapp.service.OrderService;
import com.example.foodapp.repository.FoodRepository;
import com.example.foodapp.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FoodConfig {

    @Bean
    public FoodRepository foodRepository(){
        return new FoodRepository();
    }

    @Bean
    public OrderRepository orderRepository(){
        return new OrderRepository();
    }

    @Bean
    public FoodService foodService(FoodRepository foodRepository){
        return new FoodService(foodRepository);
    }

    @Bean
    public OrderService orderService(OrderRepository orderRepository, FoodService foodService){
        return new OrderService(orderRepository,foodService);
    }

}
