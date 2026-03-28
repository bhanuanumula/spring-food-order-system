package com.example.foodapp.service;


import com.example.foodapp.model.Food;
import com.example.foodapp.repository.FoodRepository;

import java.util.List;

public class FoodService {

    private FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    public void addFood(String name, double price){
        foodRepository.addFood(new Food(name,price));
    }

    public List<Food> getFoodItems(){
        return foodRepository.getFoodList();
    }

    public Food searchFoodById(int foodId){
        return foodRepository.searchByFoodId(foodId);
    }

}
