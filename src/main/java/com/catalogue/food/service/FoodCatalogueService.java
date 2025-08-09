package com.catalogue.food.service;

import com.catalogue.food.dto.FoodCatalogue;
import com.catalogue.food.dto.FoodItemDto;
import com.catalogue.food.dto.Restaurant;
import com.catalogue.food.entity.FoodItem;
import com.catalogue.food.mapper.FoodItemMapper;
import com.catalogue.food.repository.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodRepo foodRepo;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem savedFoodItem = foodRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDto));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(savedFoodItem);
    }

    public FoodCatalogue fetchFoodCatalogueDetails(Integer restaurantId) {

        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createFoodCatalogue(foodItemList, restaurant);
    }

    private FoodCatalogue createFoodCatalogue(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCatalogue foodCatalogue = new FoodCatalogue();
        foodCatalogue.setFoodItemList(foodItemList);
        foodCatalogue.setRestaurant(restaurant);
        return foodCatalogue;
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/fetchById/" + restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodRepo.findByRestaurantId(restaurantId);
    }
}
