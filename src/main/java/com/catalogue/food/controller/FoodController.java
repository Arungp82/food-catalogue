package com.catalogue.food.controller;

import com.catalogue.food.dto.FoodCatalogue;
import com.catalogue.food.dto.FoodItemDto;
import com.catalogue.food.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foodcatalogue")
public class FoodController {

    @Autowired
    FoodCatalogueService foodCatalogueService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDto){
        FoodItemDto savedFoodItem = foodCatalogueService.addFoodItem(foodItemDto);
        return new ResponseEntity<>(savedFoodItem, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{id}")
    public ResponseEntity<FoodCatalogue> fetchRestaurantDetailsWithFoodMenu(@PathVariable Integer restaurantId){
        FoodCatalogue foodCatalogue = foodCatalogueService.fetchFoodCatalogueDetails(restaurantId);
        return new ResponseEntity<>(foodCatalogue,HttpStatus.OK);
    }
}
