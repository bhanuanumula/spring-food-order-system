package com.example.foodapp.repository;

import com.example.foodapp.model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodRepository {

    private List<Food> foodList;

    public FoodRepository(){
        foodList = new ArrayList<>();
    }

    public void addFood(Food food){
        foodList.add(food);
    }

    public List<Food> getFoodList(){
        return foodList;
    }

    public Food searchByFoodId(int foodId){
        Food food = foodList.stream().filter(f->f.getId()==foodId).findFirst().orElse(null);
        return food;
    }

}

